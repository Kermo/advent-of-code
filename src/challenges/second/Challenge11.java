package challenges.second;

/**
 * Created by jani on 11/12/2016.
 */
public class Challenge11 {

    int[] items = {2, 4, 4, 0};


    public int countMoves() {

        int moves = 0;
        int sumOfItems = 0;

        for (int itemsPerFloor : items) {
            sumOfItems += itemsPerFloor;
        }

        while (items[3] != sumOfItems) {
            int lowestFloor = 0;

            while (items[lowestFloor] == 0) {
                lowestFloor += 1;
            }

            moves += 2 * (items[lowestFloor] - 1) - 1;
            items[lowestFloor + 1] += items[lowestFloor];
            items[lowestFloor] = 0;

        }

        return moves;
    }
}
