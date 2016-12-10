import challenges.second.*;

import java.util.Date;

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

        System.out.println("==== DAY 8 ====");
        Challenge8 challenge8 = new Challenge8();
        System.out.println("Part 1: " + challenge8.countLEDs());
        System.out.println("Part 2: ");
        challenge8.drawLetters();

        System.out.println("==== DAY 9 ====");
        Challenge9 challenge9 = new Challenge9();
        System.out.println("Part 1: " + challenge9.countLength());
        System.out.println("Part 2: " + challenge9.countSecondLength());

        System.out.println("==== DAY 10 ====");
        Challenge10 challenge10 = new Challenge10();
        System.out.println("Part 1: " + challenge10.solveBot());
        System.out.println("Part 2: " + challenge10.countSum());
    }
}
