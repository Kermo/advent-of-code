package challenges.second;

import utils.FileReader;

/**
 * Created by jani on 02/12/2016.
 */
public class Challenge2 {

    public String[] dataArray;
    public String code = "";
    public int[][] keypad = new int[3][3];
    public char[][] newKeypad;

    public Challenge2() {
        FileReader reader = new FileReader();
        dataArray = reader.readFile("resources/2016/challenge2.txt");

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                keypad[j][i] = i * 3 + j + 1;
            }
        }

        newKeypad = new char[][] {
                { '\u0000', '\u0000', '1', '\u0000', '\u0000' },
                { '\u0000', '2', '3', '4', '\u0000' },
                { '5', '6', '7', '8', '9' },
                { '\u0000', 'A', 'B', 'C', '\u0000' },
                { '\u0000', '\u0000', 'D', '\u0000', '\u0000' },

        };
    }

    public String resolveCode() {

        int positionX = 1;
        int positionY = 1;

        for(int i = 0; i < dataArray.length; i++) {

            for(int j = 0; j < dataArray[i].length(); j++) {
                char direction = dataArray[i].charAt(j);

                switch (direction) {
                    case 'U':

                        if(positionY == 0) {
                            // ignore
                        } else {
                            positionY--;
                        }
                        break;
                    case 'L':
                        if(positionX == 0) {
                            // ignore
                        } else {
                            positionX--;
                        }
                        break;
                    case 'D':
                        if(positionY == 2) {
                            // ignore
                        } else {
                            positionY++;
                        }
                        break;
                    case 'R':
                        if(positionX == 2) {
                            // ignore
                        } else {
                            positionX++;
                        }
                        break;

                    default:
                        throw new RuntimeException("Failed");
                }
            }

            int codeNumber = keypad[positionX][positionY];

            code = code + codeNumber;

        }

        return code;

    }


    public String resolveComplicatedCode() {

        int positionX = 0;
        int positionY = 2;
        code = "";

        for(int i = 0; i < dataArray.length; i++) {

            for(int j = 0; j < dataArray[i].length(); j++) {
                char direction = dataArray[i].charAt(j);

                switch (direction) {
                    case 'U':

                        if(positionY == 0) {
                            // ignore
                        } else {
                            if (newKeypad[positionX][positionY - 1] == 0) {
                                // ignore
                            } else {
                                positionY--;
                            }
                        }
                        break;
                    case 'L':
                        if(positionX == 0) {
                            // ignore
                        } else {
                            if (newKeypad[positionX - 1][positionY] == 0) {
                                // ignore
                            } else {
                                positionX--;
                            }
                        }
                        break;
                    case 'D':
                        if(positionY == 4) {
                            // ignore
                        } else {
                            if (newKeypad[positionX][positionY + 1] == 0) {
                                // ignore
                            } else {
                                positionY++;
                            }
                        }
                        break;
                    case 'R':
                        if(positionX == 4) {
                            // ignore
                        } else {
                            if (newKeypad[positionX + 1][positionY] == 0) {
                                // ignore
                            } else {
                                positionX++;
                            }
                        }
                        break;

                    default:
                        throw new RuntimeException("Failed");
                }
            }

            char codeChar = newKeypad[positionY][positionX];

            code = code + codeChar;

        }

        return code;

    }
}