import challenges.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("==== DAY 1 ====");
        Challenge1 challenge1 = new Challenge1();
        System.out.println("Part 1: " + challenge1.countFloor());
        System.out.println("Part 2: " + challenge1.firstBasementPosition());

        System.out.println("==== DAY 2 ====");
        Challenge2 challenge2 = new Challenge2();
        System.out.println("Part 1: " + challenge2.resolveArea());
        System.out.println("Part 2: " + challenge2.resolveRibbon());

        System.out.println("==== DAY 3 ====");
        Challenge3 challenge3 = new Challenge3();
        System.out.println("Part 1: " + challenge3.countHouses());
        System.out.println("Part 2: " + challenge3.countCoopHouses());

        System.out.println("==== DAY 4 ====");
        Challenge4 challenge4 = new Challenge4();
        System.out.println("Part 1: " + challenge4.MD5Hash());

        System.out.println("==== DAY 5 ====");
        Challenge5 challenge5 = new Challenge5();
        System.out.println("Part 1: " + challenge5.returnNiceStringCount());
        System.out.println("Part 2: " + challenge5.returnNicestStringCount());

        System.out.println("==== DAY 6 ====");
        Challenge6 challenge6 = new Challenge6();
        System.out.println("Part 1: " + challenge6.countLights());
        System.out.println("Part 2: " + challenge6.countBrightness());


    }
}
