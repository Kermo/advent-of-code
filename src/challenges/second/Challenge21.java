package challenges.second;

import utils.FileReader;

/**
 * Created by jani on 12/21/16.
 */
public class Challenge21 {

    String[] data;
    String input = "abcdefgh";

    public Challenge21() {
        FileReader reader = new FileReader();
        data = reader.readFile("resources/2016/challenge21.txt");
    }


    public String returnScrambledString() {

        String scrambled = input;

        for (String command : data) {

            String[] splittedCommands = command.split(" ");

            if (splittedCommands[0].equals("swap")) {

                if (splittedCommands[1].equals("position")) {

                    int firstIndex = Integer.parseInt(splittedCommands[2]);
                    int secondIndex = Integer.parseInt(splittedCommands[5]);

                    char holder = scrambled.charAt(firstIndex);

                    StringBuilder stringBuilder = new StringBuilder(scrambled);
                    stringBuilder.setCharAt(firstIndex, scrambled.charAt(secondIndex));
                    stringBuilder.setCharAt(secondIndex, holder);

                    scrambled = stringBuilder.toString();

                } else {

                    int firstIndex = scrambled.indexOf(splittedCommands[2]);
                    int secondIndex = scrambled.indexOf(splittedCommands[5]);

                    char holder = splittedCommands[2].charAt(0);

                    StringBuilder stringBuilder = new StringBuilder(scrambled);
                    stringBuilder.setCharAt(firstIndex, splittedCommands[5].charAt(0));
                    stringBuilder.setCharAt(secondIndex, holder);

                    scrambled = stringBuilder.toString();
                }


            } else if (splittedCommands[0].equals("rotate")) {

                if (splittedCommands[1].equals("based")) {

                    Character ch = splittedCommands[6].charAt(0);

                    int index = scrambled.indexOf(ch);

                    int steps = index < 4 ? index + 1 : index + 2;

                    while (steps > 0) {
                        scrambled = scrambled.charAt(scrambled.length() - 1) + scrambled.substring(0, scrambled.length() - 1);
                        steps--;
                    }

                } else {

                    // How many steps?
                    int steps = Integer.parseInt(splittedCommands[2]);

                    // Left or right?
                    if (splittedCommands[1].equals("right")) {

                        while (steps > 0) {
                            scrambled = scrambled.charAt(scrambled.length() - 1) + scrambled.substring(0, scrambled.length() - 1);
                            steps--;
                        }

                    } else {

                        while (steps > 0) {
                            scrambled = scrambled.substring(1, scrambled.length()) + scrambled.charAt(0);
                            steps--;
                        }

                    }
                }

            } else if (splittedCommands[0].equals("reverse")) {

                int beginPosition = Integer.parseInt(splittedCommands[2]);
                int endPosition = Integer.parseInt(splittedCommands[4]);

                scrambled = scrambled.substring(0, beginPosition) +
                        new StringBuilder(scrambled.substring(beginPosition, endPosition + 1)).reverse() + scrambled.substring(endPosition + 1, scrambled.length());

            } else if (splittedCommands[0].equals("move")) {

                int fromPosition = Integer.parseInt(splittedCommands[2]);
                int toPosition = Integer.parseInt(splittedCommands[5]);

                char moveLetter = scrambled.charAt(fromPosition);

                scrambled = scrambled.replace(Character.toString(moveLetter), "");

                scrambled = scrambled.substring(0, toPosition) + moveLetter + scrambled.substring(toPosition, scrambled.length());
            }

        }

        return scrambled;
    }

    public void returnUnscrambledString() {
        permuteString("", "abcdefgh");
    }

    public void permuteString(String beginningString, String endingString) {

        if (endingString.length() <= 1) {
            input = beginningString + endingString;
            String result = returnScrambledString();
            if(result.equals("fbgdceah")) {
                System.out.print(input);
            }
        } else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                    permuteString(beginningString + endingString.charAt(i), newString);
                } catch (StringIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
