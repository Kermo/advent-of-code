package challenges.second;

import utils.FileReader;

/**
 * Created by jani on 12/19/16.
 */
public class Challenge18 {

    public String[] data;

    public boolean PART_TWO = false;

    public Challenge18() {

        FileReader reader = new FileReader();

        data = reader.readFile("resources/2016/challenge18.txt");
    }

    public int countSafeTiles() {

        int safeTiles = 0;

        boolean[][] grid = new boolean[400000][100];

        for (int i = 0; i < 100; i++) {
            grid[0][i] = data[0].charAt(i) == '^';

            if (!grid[0][i]) {
                safeTiles++;
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < 100; j++) {
                boolean m = j == 0 ? grid[i - 1][1] : (j == 99 ? grid[i - 1][j - 1] : grid[i - 1][j - 1] ^ grid[i - 1][j + 1]);

                if(!m) {
                    safeTiles++;
                }
                grid[i][j] = m;
            }

            if (i == 39 && !PART_TWO) {
                return safeTiles;
            }
        }

        return safeTiles;
    }

    public int countSafeTilesAgain() {
        PART_TWO = true;
        return countSafeTiles();
    }
}
