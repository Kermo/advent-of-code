package challenges.second;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jani on 12/13/16.
 */
public class Challenge13 {

    int input = 1350;
    int GOAL_X = 31;
    int GOAL_Y = 39;
    int MAX_LENGHT = 100;
    int MAX_WIDTH = 100;

    int grid[][] = new int[MAX_LENGHT][MAX_WIDTH];

    public Challenge13() {
        for (int i = 0; i < MAX_LENGHT; i++) {
            for (int j = 0; j < MAX_WIDTH; j++) {
                grid[i][j] = 0;
            }
        }

        grid[1][1] = 0;
    }

    public boolean isWall(int x, int y) {

        if (x < 0 || y < 0)
            return true;

        int a = x*x + 3*x*y + y + y*y + input;
        String binary = Integer.toBinaryString(a);
        int count = binary.length() - binary.replace("1", "").length();

        return  (count % 2) == 1;
    }

    public int countMoves() {

        for (int j = 0; j < MAX_LENGHT - 1; j++) {
            for (int i = 0; i < MAX_WIDTH - 1; i++) {

                if (isWall(i, j)) {
                    continue;
                }

                if(!isWall(i, j + 1) && grid[j + 1][i] + 1 < grid[j][i]) {
                    grid[j][i] = grid[j + 1][i] + 1;
                } else if(!isWall(i + 1, j) && grid[j][i + 1] + 1 < grid[j][i]) {
                    grid[j][i] = grid[j][i + 1] + 1;
                } else if(!isWall(i, j - 1) && grid[j - 1][i] + 1 < grid[j][i]) {
                    grid[j][i] = grid[j - 1][i] + 1;
                } else if(!isWall(i - 1, j) && grid[j][i - 1] + 1 < grid[j][i]) {
                    grid[j][i] = grid[j][i - 1] + 1;
                }
            }
        }

        return grid[GOAL_Y][GOAL_X];
    }

    public int countPossibleMoves() {

        int total = 0;

        for (int i = 0; i < MAX_LENGHT - 1; i++) {
            for (int j = 0; j < MAX_WIDTH - 1; j++) {
                if (grid[i][j] <= 50) {
                    total++;
                }
            }
        }

        return total;
    }

}
