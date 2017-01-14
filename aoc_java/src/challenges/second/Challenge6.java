package challenges.second;

import utils.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jani on 06/12/2016.
 */
public class Challenge6 {

    public String[] data;
    Map<Integer, Map<Character, Integer>> counts = new HashMap<>();

    char[] maxchars = new char[8];
    char[] minchars = new char[8];

    public Challenge6() {

        FileReader reader = new FileReader();
        data = reader.readFile("resources/2016/challenge6.txt");
    }

    public String returnMostCommons() {

        for(String line : data) {
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                counts.putIfAbsent(i, new HashMap<>());
                counts.get(i).compute(chars[i], (c, val) -> val == null ? 1 : val + 1);
            }
        }

        for (int i = 0; i < maxchars.length; i++) {
            List<Character> sorted = counts.get(i).entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).collect(Collectors.toList());
            minchars[i] = sorted.get(sorted.size() - 1);
            maxchars[i] = sorted.get(0);
        }

        return new String(minchars);

    }

    public String returnLeastCommons() {
        return new String(maxchars);
    }
}
