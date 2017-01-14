package challenges.first;

import utils.FileReader;

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

    public String[] data;

    public Challenge8() {
        FileReader reader = new FileReader();
        data = reader.readFile("resources/2015/challenge8.txt");
    }

    public int countLengthWithEscapes() {
        int allTotal = 0;

        for(int i = 0; i < data.length; i++) {
            int realLength = data[i].length();

            StringBuilder result = new StringBuilder();
            StringCharacterIterator iterator = new StringCharacterIterator(data[i]);
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

            allTotal += difference;
        }

        return allTotal;
    }

    public int countWithExtraEspaces() {
        int allTotal = 0;

        for(int i = 0; i < data.length; i++) {
            int originalLength = data[i].length();

            StringBuilder result = new StringBuilder();
            StringCharacterIterator iterator = new StringCharacterIterator(data[i]);
            char character = iterator.current();

            while(character != CharacterIterator.DONE) {
                if (character == '"') {
                    result.append(character).append('\"');
                } else if (character == '\\') {
                    result.append(character).append('\\');
                } else {
                    result.append(character);
                }

                character = iterator.next();
            }

            String string = result.toString();

            int newLength = string.length() + 2;

            int difference = newLength - originalLength;

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
