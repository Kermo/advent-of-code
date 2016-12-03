import challenges.second.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("==== DAY 1 ====");
        Challenge1 challenge1 = new Challenge1();
        System.out.println("Part 1: " + challenge1.countDistance());
        System.out.println("Part 2: " + challenge1.distanceWhenPositioningAgain());

        System.out.println("==== DAY 2 ====");
        Challenge2 challenge2 = new Challenge2();
        System.out.println("Part 1: " + challenge2.resolveCode());
        System.out.println("Part 2: " + challenge2.resolveComplicatedCode());
    }
}
