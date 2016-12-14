package challenges.second;

import utils.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Created by jani on 11/12/2016.
 */
public class Challenge11 {

    List<String> data;
    List<String> data2;

    public Challenge11() throws IOException {
        data = Files.readAllLines(Paths.get("resources/2016/challenge11a.txt"));
        data2 = Files.readAllLines(Paths.get("resources/2016/challenge11b.txt"));
    }

    public int countMovesWith10Elems() {

        Layout layout = new Layout(data);
        layout.clearSeenLayouts();
        layout.addSeenLayout(layout);
        int step = 0;
        Set<Layout> layouts = new HashSet<>();
        layouts.add(layout);
        while (true) {
            Set<Layout> nextLayouts = new HashSet<>();
            layouts.parallelStream().map(Layout::genNextMoves).forEach(nextLayouts::addAll);
            step++;
            if (nextLayouts.stream().anyMatch(Layout::isDone))
                return step;
            layouts = nextLayouts;
        }

    }

    public int countMovesWith14Elems() {

        data = data2;
        return countMovesWith10Elems();
    }

    class Layout {
        int elevatorPos = 0;

        Set<Layout> seenLayouts = new HashSet<>();
        List<Set<String>> floors = new ArrayList<>();

        public Layout(List<String> input) {
            for (String line : input) {
                Matcher m = Pattern.compile("(a \\w+-compatible microchip|a \\w+ generator)(and (a \\w+-compatible microchip)| and (a \\w+ generator))*").matcher(line);
                Set<String> floor = new HashSet<>();
                while (m.find()) {
                    floor.add(m.group(1));
                }
                floors.add(floor);
            }
        }

        public Layout(int elevatorPos, List<Set<String>> floors) {
            this.elevatorPos = elevatorPos;
            this.floors = floors;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || !(obj instanceof Layout)) {
                return false;
            }

            Layout other = (Layout) obj;
            return this.hashCode() == other.hashCode();
        }

        @Override
        public int hashCode() {
            int[][] counts = new int[2][floors.size()];
            for (int i = 0; i < this.floors.size(); i++) {
                for (String item : floors.get(i))
                    if (item.contains("generator"))
                        counts[0][i] += 1;
                    else
                        counts[1][i] += 1;
            }

            StringBuilder gensChipsCount = new StringBuilder();
            IntStream.range(0, floors.size()).mapToObj(i -> String.format("%d(%d;%d)", i, counts[0][i], counts[1][i])).forEach(gensChipsCount::append);
            return String.format("[%d]%s", elevatorPos, gensChipsCount.toString()).hashCode();
        }

        public boolean isValid() {
            for (Set<String> floor : floors) {
                Set<String> unpairedChips = new HashSet<>();
                Set<String> generators = new HashSet<>();
                for (String item : floor) {
                    if (item.contains("microchip"))
                        unpairedChips.add(item);
                    else if (item.contains("generator"))
                        generators.add(item);
                }
                generators.stream().map(generator -> generator.replace(" generator", "-compatible microchip")).forEach(unpairedChips::remove);
                if (unpairedChips.size() > 0 && generators.size() > 0)
                    return false;
            }
            return true;
        }

        public boolean isDone() {
            return floors.stream().limit(floors.size() - 1).allMatch(Set::isEmpty);
        }

        public Set<Layout> genNextMoves() {
            Set<Set<String>> possibleMoves = new HashSet<>();
            for (String item : floors.get(elevatorPos)) {
                possibleMoves.add(new HashSet<>(Arrays.asList(new String[] { item })));
                for (String item2 : floors.get(elevatorPos))
                    possibleMoves.add(new HashSet<>(Arrays.asList(new String[] { item, item2 })));
            }
            Set<Layout> nextMoves = new HashSet<>();
            for (int dir = -1; dir <= 1; dir += 2) {
                if (elevatorPos == 0 && dir == -1)
                    continue;
                if (elevatorPos == 3 && dir == 1)
                    continue;
                if (dir == -1 && floors.stream().limit(elevatorPos).allMatch(Set::isEmpty))
                    continue;

                for (Set<String> move : possibleMoves) {
                    List<Set<String>> floors = new ArrayList<>();
                    for (int i = 0; i < floors.size(); i++) {
                        Set<String> floor = new HashSet<>(floors.get(i));
                        if (i == elevatorPos)
                            floor.removeAll(move);
                        else if (i == elevatorPos + dir)
                            floor.addAll(move);
                        floors.add(floor);
                    }

                    Layout newLayout = new Layout(elevatorPos + dir, floors);
                    if (seenLayouts.contains(newLayout) || !newLayout.isValid())
                        continue;

                    seenLayouts.add(newLayout);
                    nextMoves.add(newLayout);
                }
            }
            return nextMoves;
        }

        public void addSeenLayout(Layout layout) {
            seenLayouts.add(layout);
        }

        public void clearSeenLayouts() {
            seenLayouts.clear();
        }
    }
}