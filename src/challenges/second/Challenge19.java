package challenges.second;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by jani on 12/19/16.
 */
public class Challenge19 {

    int maxSize = 3004953;

    public int returnRichElf() {

        LinkedList<Integer> elves = new LinkedList<>();

        for (int i = 1; i <= maxSize; i++) {
            elves.addLast(i);
        }

        boolean take = false;

        while(elves.size() != 1) {
            Iterator<Integer> iterator = elves.iterator();

            while (iterator.hasNext()) {
                iterator.next();

                if(take) {
                    iterator.remove();
                }

                take = !take;
            }
        }


        return elves.getFirst();
    }

    public int returnVeryRichElf() {

        LinkedList<Integer> leftElves = new LinkedList<>();
        LinkedList<Integer> rightElves = new LinkedList<>();


        for (int i = 1; i <= maxSize; i++) {
            if (i < (maxSize / 2) + 1) {
                leftElves.addLast(i);
            } else {
                rightElves.addFirst(i);
            }
        }

        while (!leftElves.isEmpty() && !rightElves.isEmpty()) {
            if (leftElves.size() > rightElves.size()) {
                leftElves.removeLast();
            } else {
                rightElves.removeLast();
            }

            rightElves.addFirst(leftElves.remove(0));
            leftElves.add(rightElves.removeLast());
        }

        if(!leftElves.isEmpty()) {
            return leftElves.getFirst();
        } else {
            return rightElves.getFirst();
        }
    }
}
