package challenges.second;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jani on 01/12/2016.
 */
public class Challenge1 {
    public String data;
    int positionX = 0;
    int positionY = 0;
    String direction = "";
    char[][] visitedGrid = new char[400][400];

    public Challenge1() {
        try {
            data = new Scanner(new File("resources/2016/challenge1.txt"), "UTF-8").useDelimiter("\\A").next();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }



    public int countDistance() {

        String[] commands = data.split(", ");

        for(int i = 0; i < commands.length; i++) {

            String[] splittedCommand = commands[i].split("(?<=\\D)(?=\\d)");

            char turn = splittedCommand[0].charAt(0);
            int moveAmout = Integer.valueOf(splittedCommand[1]);

            switch (turn) {
                case 'L':
                    if (direction.isEmpty()) {
                        direction = "L";
                        positionX = positionX - moveAmout;
                    } else {
                        if(direction.equals("P")) {
                            direction = "L";
                            positionX = positionX - moveAmout;
                        } else if (direction.equals("L")) {
                            direction = "E";
                            positionY = positionY - moveAmout;
                        } else if (direction.equals("E")) {
                            direction = "I";
                            positionX = positionX + moveAmout;
                        } else if (direction.equals("I")) {
                            direction = "P";
                            positionY = positionY + moveAmout;
                        }
                    }
                    break;
                case 'R':
                    if (direction.isEmpty()) {
                        direction = "I";
                        positionX = positionX + moveAmout;
                    } else {
                        if(direction.equals("P")) {
                            direction = "I";
                            positionX = positionX + moveAmout;
                        } else if (direction.equals("L")) {
                            direction = "P";
                            positionY = positionY + moveAmout;
                        } else if (direction.equals("E")) {
                            direction = "L";
                            positionX = positionX - moveAmout;
                        } else if (direction.equals("I")) {
                            direction = "E";
                            positionY = positionY - moveAmout;
                        }
                    }
                    break;
                default:
                    throw new RuntimeException("Direction not possible");
            }
        }

        return Math.abs(positionX) + Math.abs(positionY);
    }

    public int distanceWhenPositioningAgain() {
        int originX = 200;
        int originY = 200;
        direction = "";
        int positionX = 200;
        int positionY = 200;


        String[] commands = data.split(", ");

        for(int i = 0; i < commands.length; i++) {

            String[] splittedCommand = commands[i].split("(?<=\\D)(?=\\d)");

            char turn = splittedCommand[0].charAt(0);
            int moveAmout = Integer.valueOf(splittedCommand[1]);

            switch (turn) {
                case 'L':
                    if (direction.isEmpty()) {
                        direction = "L";
                        for(int j = 1; j <= moveAmout; j++) {
                            visitedGrid[200 - j][positionY] = 'x';
                        }

                        positionX = positionX - moveAmout;

                    } else {
                        if(direction.equals("P")) {
                            direction = "L";

                            for(int j = 1; j <= moveAmout; j++) {
                                if (visitedGrid[positionX - j][positionY] != 'x') {
                                    visitedGrid[positionX - j][positionY] = 'x';
                                } else {
                                    return Math.abs(positionX - 200 - j) + Math.abs(positionY - 200);
                                }
                            }

                            positionX = positionX - moveAmout;

                        } else if (direction.equals("L")) {
                            direction = "E";

                            for(int j = 1; j <= moveAmout; j++) {
                                if (visitedGrid[positionX][positionY - j] != 'x') {
                                    visitedGrid[positionX][positionY - j] = 'x';
                                } else {
                                    return Math.abs(positionX - 200) + Math.abs(positionY - 200 - j);
                                }
                            }

                            positionY = positionY - moveAmout;

                        } else if (direction.equals("E")) {

                            direction = "I";

                            for(int j = 1; j <= moveAmout; j++) {
                                if (visitedGrid[positionX + j][positionY] != 'x') {
                                    visitedGrid[positionX + j][positionY] = 'x';
                                } else {
                                    return Math.abs(positionX - 200 + j) + Math.abs(positionY - 200);
                                }
                            }

                            positionX = positionX + moveAmout;

                        } else if (direction.equals("I")) {
                            direction = "P";

                            for(int j = 1; j <= moveAmout; j++) {
                                if (visitedGrid[positionX][positionY + j] != 'x') {
                                    visitedGrid[positionX][positionY + j] = 'x';
                                } else {
                                    return Math.abs(positionX - 200) + Math.abs(positionY - 200 + j);
                                }
                            }

                            positionY = positionY + moveAmout;
                        }
                    }
                    break;
                case 'R':
                    if (direction.isEmpty()) {
                        direction = "I";
                        for(int j = 1; j <= moveAmout; j++) {
                            visitedGrid[200 + j][positionY] = 'x';
                        }
                        positionX = positionX + moveAmout;

                    } else {
                        if(direction.equals("P")) {
                            direction = "I";

                            for(int j = 1; j <= moveAmout; j++) {
                                if (visitedGrid[positionX + j][positionY] != 'x') {
                                    visitedGrid[positionX + j][positionY] = 'x';
                                } else {
                                    return Math.abs(positionX + j - 200) + Math.abs(positionY - 200);
                                }
                            }

                            positionX = positionX + moveAmout;

                        } else if (direction.equals("L")) {
                            direction = "P";

                            for(int j = 1; j <= moveAmout; j++) {
                                if (visitedGrid[positionX][positionY + j] != 'x') {
                                    visitedGrid[positionX][positionY + j] = 'x';
                                } else {
                                    return Math.abs(positionX - 200) + Math.abs(positionY - j - 200);
                                }
                            }

                            positionY = positionY + moveAmout;

                        } else if (direction.equals("E")) {

                            direction = "L";

                            for(int j = 1; j <= moveAmout; j++) {
                                if (visitedGrid[positionX - j][positionY] != 'x') {
                                    visitedGrid[positionX - j][positionY] = 'x';
                                } else {
                                    return Math.abs(positionX - 200 - j) + Math.abs(positionY - 200);
                                }
                            }

                            positionX = positionX - moveAmout;

                        } else if (direction.equals("I")) {

                            direction = "E";

                            for(int j = 1; j <= moveAmout; j++) {
                                if (visitedGrid[positionX][positionY - j] != 'x') {
                                    visitedGrid[positionX][positionY - j] = 'x';
                                } else {
                                    return Math.abs(positionX - 200) + Math.abs(positionY - 200 - j);
                                }
                            }

                            positionY = positionY - moveAmout;

                        }
                    }
                    break;
                default:
                    throw new RuntimeException("Direction not possible");
            }

        }

        return Math.abs(positionX - 120) + Math.abs(positionY - 120);
    }
}
