package challenges.second;

import utils.FileReader;

/**
 * Created by jani on 09/12/2016.
 */
public class Challenge9 {

    public String[] data;
    long partTwoLength = 0L;
    String partTwoString;


    public Challenge9() {
        FileReader reader = new FileReader();
        data = reader.readFile("resources/2016/challenge9.txt");
        partTwoString = data[0];
    }

    public int countLength() {
        int length = 0;

        for (int i = 0; i < data.length; i++) {
            char[] chars = data[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {

                if(chars[j] == ' ') {
                    // Ignored
                } else if (chars[j] == '(') {
                    int end = data[i].indexOf(')', j);
                    int howMuch = Integer.valueOf(data[i].substring(j + 1, end).split("x")[0]);
                    int times = Integer.valueOf(data[i].substring(j + 1, end).split("x")[1]);
                    String repeat = data[i].substring(end + 1, end + 1 + howMuch);
                    length += times * repeat.length();
                    j = end + howMuch;
                } else {
                    length++;
                }
            }
        }

        return length;
    }

    public long solveAnotherStringLength(String string) {

            partTwoLength = 0;

            char[] chars = string.toCharArray();

            for (int j = 0; j < chars.length; j++) {

                if (chars[j] == ' ') {
                    // Ignored
                } else if (chars[j] == '(') {
                    int end = string.indexOf(')', j);
                    int howMuch = Integer.valueOf(string.substring(j + 1, end).split("x")[0]);
                    int times = Integer.valueOf(string.substring(j + 1, end).split("x")[1]);
                    String repeat = string.substring(end + 1, end + 1 + howMuch);
                    partTwoLength += times * solveAnotherStringLength(repeat);
                    j = end + howMuch;
                } else {
                    partTwoLength++;
                }
            }

        return partTwoLength;
    }

    public long countSecondLength() {
        return solveAnotherStringLength(partTwoString);
    }
}
