package challenges.second;

import utils.FileReader;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jani on 04/12/2016.
 */
public class Challenge4 {

    public List<String[]> data;

    public Challenge4() {

        FileReader reader = new FileReader();
        data = reader.getFileLinesSplit("resources/2016/challenge4.txt", "-");
    }

    public String getCheckSum(String s ) {
        return s.substring(s.indexOf("[")  + 1, s.length() - 1);
    }

    public int getId(String s) {
        return Integer.parseInt(s.substring(0, s.indexOf("[")));
    }

    public char rotate(int rotation, char c) {
        return (char) ((((c - 'a') + rotation) % 26) + 'a');
    }

    public void resolve() {

        List<String[]> input = data;
        List<String[]> part2data = new ArrayList<>();
        int sum = 0;

        for (String[] each : input) {
            Map<Character, Integer> freq = new HashMap<>();

            for (int i = 0; i < each.length - 1; i++) {
                each[i].chars()
                        .filter(x -> x != '-')
                        .forEach(x -> freq.put((char) x, freq.getOrDefault((char) x, 0) + 1));
            }

            String top5 = freq.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .limit(5)
                    .map(Map.Entry::getKey)
                    .map(x -> Character.toString(x))
                    .collect(Collectors.joining(""));

            String checkSum = getCheckSum(each[each.length - 1]);

            if (top5.equals(checkSum)) {
                sum += getId(each[each.length - 1]);

                part2data.add(each);
            }

        }

        System.out.println(sum);

        for (String[] each : part2data) {
            String temp = "";
            for (int i = 0; i < each.length - 1; i++) {
                for (int j = 0; j < each[i].length(); j++) {
                    temp += rotate(getId(each[each.length - 1]), each[i].charAt(j));
                }
                temp += "-";
            }
            temp += each[each.length - 1];
            if (temp.startsWith("northpole-object-storage")) System.out.println(temp);
        }

    }
}
