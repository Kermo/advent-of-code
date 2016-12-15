package challenges.second;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jani on 12/15/16.
 */
public class Challenge15 {

    private class Disc {
        int positions;
        int pos;

        Disc(int positions, int pos) {
            this.positions = positions;
            this.pos = pos;
        }

        public int getPositions() {
            return positions;
        }

        public int getPosition() {
            return pos;
        }
    }

    private final List<Disc> discList = Arrays.asList(
            new Disc(5, 2),
            new Disc(13, 7),
            new Disc(17, 10),
            new Disc(3, 2),
            new Disc(19, 9),
            new Disc(7, 0),
            new Disc(11, 0)
    );


    public int returnFirstTime() {
        int time;

        for (time = 0; time >= 0; time++) {
            boolean fail = false;
            for (int i = 0; i < discList.size(); i++) {
                Disc disc = discList.get(i);

                if ((disc.getPosition() + time + i + 1) % disc.getPositions() != 0) {
                    fail = true;
                }
            }

            if (!fail) {
                return time;
            }
        }

        return time;
    }
}
