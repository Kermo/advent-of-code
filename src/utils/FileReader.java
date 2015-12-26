package utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jani on 07/12/15.
 */
public class FileReader {

    public String data;
    public String[] lines;

    public FileReader() {
        data = "";
        lines = null;
    }


    public String[] readFile(String fileLocation) {
        try {
            Scanner scanner = new Scanner(new File("resources/challenge9.txt"));

            while (scanner.hasNext()) {
                data += scanner.nextLine() + "\n";
            }

            lines = data.split("\n");

        } catch (IOException e) {
            System.out.println("Data parsing failed");
        }

        return lines;
    }
}
