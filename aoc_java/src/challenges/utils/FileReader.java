package challenges.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

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
            Scanner scanner = new Scanner(new File(fileLocation));

            while (scanner.hasNext()) {
                data += scanner.nextLine() + "\n";
            }

            lines = data.split("\n");

        } catch (IOException e) {
            System.out.println("Data parsing failed");
        }

        return lines;
    }

    public List<String[]> getFileLinesSplit(String fileName, String delimiter) {
        List<String[]> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String input;
            while ((input = br.readLine()) != null) {
                try {
                    String[] s = input.split(delimiter);
                    list.add(s);
                } catch (PatternSyntaxException pse) {
                    System.out.println("Bad regex syntax. Delimiter \"" + delimiter + " \"");
                    return null;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return list;
    }
}
