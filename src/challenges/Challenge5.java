package challenges;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jani on 05/12/15.
 */
public class Challenge5 {

    public String data;
    public String[] dataArray;

    public Challenge5() {
        try {
            Scanner scanner = new Scanner(new File("resources/challenge5.txt"));

            while (scanner.hasNext()) {
                data += scanner.nextLine() + ",";
            }

            dataArray = data.split(",");


        } catch (IOException e) {
            System.out.println("Data parsing failed");
        }
    }

    public int returnNiceStringCount() {
        int count = 0;


        for(int i = 0; i < dataArray.length; i++) {

            boolean threeVowels = containsThreeVowels(dataArray[i]);
            boolean blackListed = isBlackListed(dataArray[i]);
            boolean doubleLetters = hasDoubleLetters(dataArray[i]);

            if(threeVowels && !blackListed && doubleLetters) {
                count++;
            }
        }

        return count;
    }

    public int returnNicestStringCount() {
        int count = 0;

        for(int i = 0; i < dataArray.length; i++) {

            boolean hasPair = hasPairOfChars(dataArray[i]);
            boolean hasRepeat = hasRepeat(dataArray[i]);

            if(hasPair && hasRepeat) {
                count++;
            }
        }

        return count;
    }

    public boolean containsThreeVowels(String string) {

        int vowelCount = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for(int i = 0; i < string.length(); i++) {
            if(new String(vowels).indexOf(string.charAt(i)) >= 0) {
                vowelCount++;
            }
        }

        return vowelCount >= 3;

    }

    public boolean isBlackListed(String string) {

        String[] blackListedStrings = {"ab", "cd", "pq", "xy"};

        for(int i = 0; i < blackListedStrings.length; i++) {

            if(string.contains(blackListedStrings[i])) {
                return true;
            }
        }

        return false;
        
    }

    public boolean hasDoubleLetters(String string) {

        for(int i = 1; i < string.length(); i++) {
            if(string.charAt(i) == string.charAt(i - 1)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasPairOfChars(String string) {

        for(int i = 0; i < string.length() - 1; i++) {

            char first = string.charAt(i);
            char second = string.charAt(i + 1);

            for(int j = i + 2; j < string.length() - 1; j++) {
                if(string.charAt(j) == first && string.charAt(j + 1) == second) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean hasRepeat(String string) {
        for(int i = 0; i < string.length() - 2; i++) {
            if(string.charAt(i) == string.charAt(i + 2)) {
                return true;
            }
        }

        return false;
    }
}
