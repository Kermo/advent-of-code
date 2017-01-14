package challenges.first;

import utils.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by jani on 07/12/15.
 */
public class Challenge6 {

    public int[][] grid = new int[1000][1000];
    public String[] dataArray;

    public Challenge6() {
        FileReader reader = new FileReader();
        dataArray = reader.readFile("resources/2015/challenge6.txt");
    }

    public int countLights() {
        int count = 0;
        String method;
        String[] data = new String[2];
        String[] firstCorner = new String[2];
        String[] secondCorner = new String[2];

        for(int a = 0; a < dataArray.length; a++) {
            if (dataArray[a].contains("turn on")) {
                method = "turnOn";
            } else if (dataArray[a].contains("turn off")) {
                method = "turnOff";
            } else {
                method = "toggle";
            }

            String line = dataArray[a].replace(" through ", ".").replaceAll("[^0-9?!\\.,]", "");
            data = line.split(Pattern.quote("."));
            firstCorner = data[0].split(",");
            secondCorner = data[1].split(",");


            int startX = Integer.parseInt(firstCorner[0]);
            int startY = Integer.parseInt(firstCorner[1]);
            int endX = Integer.parseInt(secondCorner[0]);
            int endY = Integer.parseInt(secondCorner[1]);

            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (method.equals("turnOn")) {
                        grid[i][j] = 1;
                    } else if (method.equals("turnOff")) {
                        grid[i][j] = 0;
                    } else {
                        if (grid[i][j] == 1)
                            grid[i][j] = 0;
                        else if (grid[i][j] == 0) {
                            grid[i][j] = 1;
                        }
                    }
                }
            }
        }

        for(int y = 0; y < 1000; y++) {
            for(int z = 0; z < 1000; z++) {
                if (grid[y][z] == 1)
                    count++;
            }
        }

        return count;
    }

    public int countBrightness() {

        for(int o = 0; o < 1000; o++) {
            for(int p = 0; p < 1000; p++) {
                grid[o][p] = 0;
            }
        }

        int brightness = 0;
        String method;
        String[] data = new String[2];
        String[] firstCorner = new String[2];
        String[] secondCorner = new String[2];

        for(int a = 0; a < dataArray.length; a++) {
            if (dataArray[a].contains("turn on")) {
                method = "turnOn";
            } else if (dataArray[a].contains("turn off")) {
                method = "turnOff";
            } else {
                method = "toggle";
            }

            String line = dataArray[a].replace(" through ", ".").replaceAll("[^0-9?!\\.,]", "");
            data = line.split(Pattern.quote("."));
            firstCorner = data[0].split(",");
            secondCorner = data[1].split(",");


            int startX = Integer.parseInt(firstCorner[0]);
            int startY = Integer.parseInt(firstCorner[1]);
            int endX = Integer.parseInt(secondCorner[0]);
            int endY = Integer.parseInt(secondCorner[1]);

            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (method.equals("turnOn")) {
                        grid[i][j] += 1;
                    } else if (method.equals("turnOff")) {
                        if(grid[i][j] > 0)
                            grid[i][j] -= 1;
                    } else {
                        grid[i][j] += 2;
                    }
                }
            }
        }

        for(int y = 0; y < 1000; y++) {
            for(int z = 0; z < 1000; z++) {
                brightness += grid[y][z];
            }
        }

        return brightness;
    }
}
