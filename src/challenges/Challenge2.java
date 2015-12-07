package challenges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jani on 04/12/15.
 */
public class Challenge2 {

    public String data;
    public String[] stringDimension;
    public int length;
    public int width;
    public int height;
    public int totalArea = 0;
    public int totalRibbon = 0;

    public int resolveArea() {
        try {
            Scanner scanner = new Scanner(new File("resources/challenge2.txt"));

            while(scanner.hasNext()) {
                data = scanner.nextLine();

                stringDimension = data.split("x");

                length = Integer.parseInt(stringDimension[0]);
                width = Integer.parseInt(stringDimension[1]);
                height = Integer.parseInt(stringDimension[2]);

                int area1 = length * width;
                int area2 = width * height;
                int area3 = height * length;

                int smallest = Math.min(area1, Math.min(area2, area3));

                int packageArea = 2 * area1 + 2 * area2 + 2 * area3 + smallest;

                totalArea += packageArea;

            }
        } catch (IOException e) {
            System.out.println("Data parsing failed");
        }

        return totalArea;
    }

    public int resolveRibbon() {
        try {
            Scanner scanner = new Scanner(new File("resources/challenge2.txt"));

            while(scanner.hasNext()) {
                data = scanner.nextLine();

                stringDimension = data.split("x");

                length = Integer.parseInt(stringDimension[0]);
                width = Integer.parseInt(stringDimension[1]);
                height = Integer.parseInt(stringDimension[2]);

                int largest = Math.max(length, Math.max(width, height));
                int wrappingPackage = 0;

                if(length == largest) {
                    wrappingPackage = 2 * width + 2 * height;
                } else if (width == largest) {
                    wrappingPackage = 2 * length + 2 * height;
                } else if (height == largest) {
                    wrappingPackage = 2 * width + 2 * length;
                }
                int volume = length * width * height;

                int present = wrappingPackage + volume;

                totalRibbon += present;

            }
        } catch (IOException e) {
            System.out.println("Data parsing failed");
        }

        return totalRibbon;
    }
}
