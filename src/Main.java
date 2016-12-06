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

        System.out.println("==== DAY 3 ====");
        Challenge3 challenge3 = new Challenge3();
        System.out.println("Part 1: " + challenge3.countValidTriangles());
        System.out.println("Part 2: " + challenge3.countValidTrianglesFromColumns());

        System.out.println("==== DAY 4 ====");
        Challenge4 challenge4 = new Challenge4();
        challenge4.resolve();

        System.out.println("==== DAY 5 ====");
        Challenge5 challenge5 = new Challenge5();
        try {
            challenge5.resolve();
        } catch (Exception e) {
            //
        }

    }
}
