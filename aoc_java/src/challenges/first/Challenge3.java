package challenges.first;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jani on 04/12/15.
 */
public class Challenge3 {

    public int[][] grid = new int[5000][5000];
    public int xPosition = 2500;
    public int yPosition = 2500;
    public int roboXPosition = 2500;
    public int roboYPosition = 2500;
    public int giftedHouses = 0;
    public int coopHouses = 0;
    public String directions;

    public Challenge3() {
        try {
            directions = new Scanner(new File("resources/2015/challenge3.txt"), "UTF-8").useDelimiter("\\A").next();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public int countHouses() {

        for(int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);

            if(direction == '^') {
                yPosition++;
            } else if(direction == '<') {
                xPosition--;
            } else if(direction == '>') {
                xPosition++;
            } else if(direction == 'v') {
                yPosition--;
            }

            if(grid[xPosition][yPosition] != 1) {
                grid[xPosition][yPosition] = 1;
            }
        }

        for(int x = 0; x < 5000; x++) {
            for(int y = 0; y < 5000; y++) {
                if(grid[x][y] == 1) {
                    giftedHouses++;
                }
            }
        }

        return giftedHouses;
    }

    public int countCoopHouses() {

        xPosition = 2500;
        yPosition = 2500;

        for(int x = 0; x < 5000; x++) {
            for(int y = 0; y < 5000; y++) {
                grid[x][y] = 0;
            }
        }

        grid[2500][2500] = 1;

        for(int i = 0; i < directions.length(); i = i + 2) {
            char direction = directions.charAt(i);

            if (direction == '^') {
                yPosition++;
            } else if (direction == '<') {
                xPosition--;
            } else if (direction == '>') {
                xPosition++;
            } else if (direction == 'v') {
                yPosition--;
            }

            if (grid[xPosition][yPosition] != 1) {
                grid[xPosition][yPosition] = 1;
            }
        }

        for(int j = 1; j < directions.length(); j = j + 2) {
            char direction = directions.charAt(j);

            if (direction == '^') {
                roboYPosition++;
            } else if (direction == '<') {
                roboXPosition--;
            } else if (direction == '>') {
                roboXPosition++;
            } else if (direction == 'v') {
                roboYPosition--;
            }

            if (grid[roboXPosition][roboYPosition] != 1) {
                grid[roboXPosition][roboYPosition] = 1;
            }
        }

        for(int x = 0; x < 5000; x++) {
            for(int y = 0; y < 5000; y++) {
                if(grid[x][y] == 1) {
                    coopHouses++;
                }
            }
        }

        return coopHouses;
    }
}
