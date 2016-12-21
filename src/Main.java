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

        System.out.println("==== DAY 11 ====");
        try {
            Challenge11 challenge11 = new Challenge11();
            System.out.println("Part 1: " + challenge11.countMoves());
            System.out.println("Part 2: " + challenge11.countSecondMoves());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("==== DAY 12 ====");
        Challenge12 challenge12 = new Challenge12();
        System.out.println("Part 1: " + challenge12.valueOfA());
        //System.out.println("Part 2: " + challenge12.valueOfAAfterC());

        System.out.println("==== DAY 13 ====");
        Challenge13 challenge13 = new Challenge13();
        System.out.println("Part 1: " + challenge13.countMoves());
        System.out.println("Part 2: " + challenge13.countPossibleMoves());

        System.out.println("==== DAY 14 ====");
        Challenge14 challenge14 = new Challenge14();
        System.out.println("Part 1: " + challenge14.findLastIndes());
        //System.out.println("Part 2: " + challenge14.findLastIndesWithExtra());

        System.out.println("==== DAY 15 ====");
        Challenge15 challenge15 = new Challenge15();
        System.out.println("Part 1: " + challenge15.returnFirstTime());

        System.out.println("==== DAY 16 ====");
        Challenge16 challenge16 = new Challenge16();
        System.out.println("Part 1: " + challenge16.returnChecksum());
        System.out.println("Part 2: " + challenge16.returnSecondChecksum());

        System.out.println("==== DAY 18 ====");
        Challenge18 challenge18 = new Challenge18();
        System.out.println("Part 1: " + challenge18.countSafeTiles());
        System.out.println("Part 2: " + challenge18.countSafeTilesAgain());

        System.out.println("==== DAY 19 ====");
        Challenge19 challenge19 = new Challenge19();
        System.out.println("Part 1: " + challenge19.returnRichElf());
        System.out.println("Part 2: " + challenge19.returnVeryRichElf());

        System.out.println("==== DAY 20 ====");
        Challenge20 challenge20 = new Challenge20();
        System.out.println("Part 1: " + challenge20.returnMinIP());
        System.out.println("Part 2: " + challenge20.returnValidIpCount());

        System.out.println("==== DAY 21 ====");
        Challenge21 challenge21 = new Challenge21();
        System.out.println("Part 1: " + challenge21.returnScrambledString());
        System.out.print("Part 2: " + challenge21.returnUnscrambledString());


    }
}
