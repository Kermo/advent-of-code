package challenges;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

/**
 * Created by jani on 10/12/15.
 */
public class Challenge8 {

    public String data = "";
    public String[] lines;

    public Challenge8() {
        try {
            Scanner scanner = new Scanner(new File("resources/challenge8.txt"));

            while (scanner.hasNext()) {
                data += scanner.nextLine() + "\n";
            }

            lines = data.split("\n");

        } catch (IOException e) {
            System.out.println("Data parsing failed");
        }
    }

    public int countLengthWithEscapes() {
        int allTotal = 0;

        for(int i = 0; i < lines.length; i++) {
            int realLength = lines[i].length();

            StringBuilder result = new StringBuilder();
            StringCharacterIterator iterator = new StringCharacterIterator(lines[i]);
            char character = iterator.current();

            while(character != CharacterIterator.DONE) {
                if (character == '\"') {
                    result.append("&quot;");
                } else if (character == '\\') {
                    addCharEntity(92, result);
                } else {
                    result.append(character);
                }

                character = iterator.next();
            }

            String string = result.toString();

            String trimmedString = string;

            trimmedString = trimmedString.replaceAll("&#092;&#092;", "k");

            trimmedString = trimmedString.replaceAll("&#092;&quot;", "j");

            for(int index = trimmedString.indexOf("&#092;x"); index >= 0; index = trimmedString.indexOf("&#092;x", index + 1)) {
                try {
                    String replace = trimmedString.substring(index, index + 9);
                    trimmedString = trimmedString.replaceAll(replace, "i");
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Error");
                }
            }

            trimmedString = trimmedString.replaceAll("&quot;", "");

            int trimmedLength = trimmedString.length();

            int difference = realLength - trimmedLength;

            if(difference < 0) {
                System.out.println("Fucked");
            }

            allTotal += difference;
        }

        return allTotal;
    }

    public void addCharEntity(Integer aIdx, StringBuilder aBuilder) {
        String padding = "";

        if (aIdx <= 9) {
            padding = "00";
        } else if (aIdx <= 99) {
            padding = "0";
        } else {
            // no prefix
        }
        String number = padding + aIdx.toString();
        aBuilder.append("&#" + number + ";");
    }
}
