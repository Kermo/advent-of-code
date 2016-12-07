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
        System.out.println("Part 1: " + challenge4.resolveSumOfChecksums());
        System.out.println("Part 2: " + challenge4.getSectorId());

        /*System.out.println("==== DAY 5 ====");
        Challenge5 challenge5 = new Challenge5();
        try {
            challenge5.resolve();
        } catch (Exception e) {
            //
        }*/

        System.out.println("==== DAY 6 ====");
        Challenge6 challenge6 = new Challenge6();
        System.out.println("Part 1: " + challenge6.returnMostCommons());
        System.out.println("Part 2: " + challenge6.returnLeastCommons());

        System.out.println("==== DAY 7 ====");
        Challenge7 challenge7 = new Challenge7();
        System.out.println("Part 1: " + challenge7.countTLSips());
        System.out.println("Part 2: " + challenge7.countValidSSLs());

    }
}
