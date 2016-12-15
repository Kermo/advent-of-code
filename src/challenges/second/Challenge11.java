package challenges.second;

import utils.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jani on 11/12/2016.
 */
public class Challenge11 {

    List<String> data;

    boolean partTwo = false;

    public Challenge11() throws IOException {
        data = Files.readAllLines(Paths.get("resources/2016/challenge11.txt"));
    }

    public static int solve(Layout layout) {

        Layout.seenLayouts.clear();
        Layout.seenLayouts.add(layout);
        int step = 0;
        List<Layout> layouts = new ArrayList<>();
        layouts.add(layout);
        while (!layouts.parallelStream().anyMatch(Layout.isDone)) {
            layouts = layouts.parallelStream().map(Layout::genNextMoves).flatMap(Set::stream).collect(Collectors.toList());
            step++;
        }
        return step;

    }

    public int countMoves() {
        Layout layout = new Layout(data);

        if(partTwo) {
            layout.floors.get(0).addAll(Arrays.asList(new String[] { "a elerium generator", "a elerium-compatible microchip", "a dilithium generator", "a dilithium-compatible microchip" }));
        }

        return solve(layout);
    }

    public int countSecondMoves() {
        partTwo = true;
        return countMoves();
    }
}

class Layout {
    int elevatorPos = 0;

    static Set<Layout> seenLayouts = new HashSet<>();
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
        long[][] counts = new long[2][floors.size()];
        for (int i = 0; i < this.floors.size(); i++) {
            counts[0][i] = floors.get(i).stream().filter(item -> item.contains("microchip")).count();
            counts[1][i] = floors.get(i).stream().filter(item -> item.contains("generator")).count();
        }

        StringBuilder gensChipsCount = new StringBuilder();
        IntStream.range(0, floors.size()).mapToObj(i -> String.format("%d(%d;%d)", i, counts[0][i], counts[1][i])).forEach(gensChipsCount::append);
        return String.format("[%d]%s", elevatorPos, gensChipsCount.toString()).hashCode();
    }

    public boolean isValid() {
        for (Set<String> floor : floors) {
            Set<String> unpairedChips = floor.stream().filter(item -> item.contains("microchip")).collect(Collectors.toSet());
            Set<String> generators    = floor.stream().filter(item -> item.contains("generator")).collect(Collectors.toSet());
            generators.stream().map(generator -> generator.replace(" generator", "-compatible microchip")).forEach(unpairedChips::remove);
            if (unpairedChips.size() > 0 && generators.size() > 0)
                return false;
        }
        return true;
    }

    static Predicate<Layout> isDone = layout -> layout.floors.stream().limit(layout.floors.size() - 1).allMatch(Set::isEmpty);

    public Set<Layout> genNextMoves() {
        Set<Set<String>> possibleMoves = new HashSet<>();
        floors.get(elevatorPos).stream().map(item -> Stream.of(item).collect(Collectors.toSet())).forEach(possibleMoves::add);
        for (String item : floors.get(elevatorPos))
            for (String item2 : floors.get(elevatorPos))
                possibleMoves.add(Stream.of(item, item2).collect(Collectors.toSet()));

        Set<Layout> nextMoves = new HashSet<>();
        for (int dir = -1; dir <= 1; dir += 2) {
            if (elevatorPos == 0 && dir == -1 || elevatorPos == (floors.size() - 1) && dir == 1)
                continue;
            if (dir == -1 && floors.stream().limit(elevatorPos).allMatch(Set::isEmpty))
                continue;

            for (Set<String> move : possibleMoves) {
                List<Set<String>> floorsneu = new ArrayList<>();
                for (int i = 0; i < floors.size(); i++) {
                    Set<String> f = new HashSet<>(floors.get(i));
                    if (i == elevatorPos)
                        f.removeAll(move);
                    else if (i == elevatorPos + dir)
                        f.addAll(move);
                    floorsneu.add(f);
                }

                Layout newLayout = new Layout(elevatorPos + dir, floorsneu);
                if (seenLayouts.contains(newLayout) || !newLayout.isValid())
                    continue;

                seenLayouts.add(newLayout);
                nextMoves.add(newLayout);
            }
        }
        return nextMoves;
    }
}
