package challenges.second;

import utils.FileReader;

/**
 * Created by jani on 12/22/16.
 */
public class Challenge22 {

    public String[] data;
    public String[][] grid = new String[28][38];
    int emptyNodeSpace = 87;


    public Challenge22() {
        FileReader reader = new FileReader();
        data = reader.readFile("resources/2016/challenge22.txt");
    }

    public int countValidPairs() {
        int validPairs = 0;

        for (int i = 2; i < data.length; i++) {
            String[] splittedData = data[i].split("\\s+");

            String[] positions = splittedData[0].split("-");

            Integer xPosition = Integer.valueOf(positions[1].substring(1, positions[1].length()));
            Integer yPosition = Integer.valueOf(positions[2].substring(1, positions[2].length()));


            String usage = splittedData[2].substring(0, splittedData[2].length() - 1) + "/" +
                    splittedData[3].substring(0, splittedData[3].length() - 1);

            grid[yPosition][xPosition] = usage;
        }

        for (int i = 0; i < 38; i++) {
            for (int j = 0; j < 28; j++) {
                String values = grid[j][i];
                String usedSpace = values.split("/")[0];

                if(Integer.parseInt(usedSpace) <= emptyNodeSpace) {
                    validPairs++;
                }
            }
        }

        // validPairs includes the starting node so have to remove it
        return validPairs - 1;
    }
}
