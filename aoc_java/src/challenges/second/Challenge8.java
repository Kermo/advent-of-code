package challenges.second;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jani on 08/12/2016.
 */
public class Challenge8 {

    public int MAX_LENGHT = 50;
    public int MAX_WIDTH = 6;
    public char[][] grid = new char[MAX_LENGHT][MAX_WIDTH];
    public String[] dataArray;
    public int lightLEDs;

    public Challenge8() {
        FileReader reader = new FileReader();
        dataArray = reader.readFile("resources/2016/challenge8.txt");
    }

    public int countLEDs() {

        for (int i = 0; i < dataArray.length; i++) {

            String[] command = dataArray[i].split(" ");

            if(command[0].equals("rect")) {
                drawRectangle(command[1]);
            } else if (command[0].equals("rotate")) {
                move(command[2], command[4]);
            }

            for (int j = 0; j < MAX_LENGHT; j++) {
                for (int k = 0; k < MAX_WIDTH; k++) {
                    if (grid[j][k] == '@') {
                        grid[j][k] = '#';
                    }
                }
            }
        }

        for (int i = 0; i < MAX_LENGHT; i++) {
            for (int j = 0; j < MAX_WIDTH; j++) {
                if (grid[i][j] == '#') {
                    lightLEDs++;
                }
            }
        }


        return lightLEDs;
    }

    public void drawRectangle(String command) {

        String[] dimensions = command.split("x");

        for (int i = 0; i < Integer.valueOf(dimensions[0]); i++) {
            for (int j = 0; j < Integer.valueOf(dimensions[1]); j++) {
                grid[i][j] = '#';
            }
        }
    }

    public void move(String column, String amount) {

        String[] position = column.split("=");

        if (position[0].equals("x")) {
            List<Integer> lightedLocations = new ArrayList<Integer>();
            for (int i = 0; i < MAX_WIDTH; i++) {
                if(grid[Integer.valueOf(position[1])][i] == '#') {

                    lightedLocations.add(i);

                    grid[Integer.valueOf(position[1])][i] = '\u0000';
                }
            }

            for(Integer location : lightedLocations) {
                int offset = (location + Integer.valueOf(amount)) % MAX_WIDTH;

                grid[Integer.valueOf(position[1])][offset] = '#';
            }
        } else if (position[0].equals("y")) {
            List<Integer> lightedLocations = new ArrayList<Integer>();
            for (int i = 0; i < MAX_LENGHT; i++) {
                if (grid[i][Integer.valueOf(position[1])] == '#') {

                    lightedLocations.add(i);

                    grid[i][Integer.valueOf(position[1])] = '\u0000';
                }
            }

            for(Integer location : lightedLocations) {
                int offset = (location + Integer.valueOf(amount)) % MAX_LENGHT;

                grid[offset][Integer.valueOf(position[1])] = '#';
            }
        }
    }

    public void drawLetters() {

        for (int i = 0; i < MAX_WIDTH; i++) {
            for (int j = 0; j < MAX_LENGHT; j++) {

                if(grid[j][i] == '#')
                    System.out.print(grid[j][i]);
                else
                    System.out.print(' ');
            }

            System.out.print("\n");
        }
    }
}
