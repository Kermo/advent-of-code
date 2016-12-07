package challenges.second;

import utils.FileReader;

import java.util.*;

/**
 * Created by jani on 07/12/2016.
 */
public class Challenge7 {

    public String[] data;
    public int validIps;
    public int validSSLs;

    public Challenge7() {

        FileReader reader = new FileReader();
        data = reader.readFile("resources/2016/challenge7.txt");
    }

    public int countTLSips() {

        for (int i = 0; i < data.length; i++) {
            List<String> bracketed = new ArrayList<>();
            List<String> nonbracketed = new ArrayList<>();

            data[i] += "\0";

            String position = "";

            for (char ch : data[i].toCharArray()) {
                position += ch;

                if (ch == '[' || ch == '\0') {
                    nonbracketed.add(position.substring(0, position.length() - 1));
                    position = "";
                } else if (ch == ']') {
                    bracketed.add(position.substring(0, position.length() - 1));
                    position = "";
                }
            }

            if(countABBA(bracketed) == 0 && countABBA(nonbracketed) != 0) {
                validIps++;
            }

            if(isValidSSL(bracketed, nonbracketed)) {
                validSSLs++;
            }
        }

        return validIps;
    }

    public int countValidSSLs() {
        return validSSLs;
    }

    public int countABBA(List<String> strings) {
        int count = 0;
        for (String s : strings) {
            for(int i = 0; i <= s.length() - 4; i++) {
                if(isABBA(s.substring(i, i + 4))) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public boolean isABBA(String s) {
        if(s.charAt(0) != s.charAt(1) && s.charAt(0) == s.charAt(3) && s.charAt(1) == s.charAt(2)) {
            return true;
        }

        return false;
    }

    public boolean isValidSSL(List<String> bracketed, List<String> nonBracketed) {
        Set<String> ABAs = new HashSet<>();
        Set<String> invertedBABs = new HashSet<>();

        for (String s : bracketed) {
            for(int i = 0; i <= s.length() - 3; i++) {
                String sub = s.substring(i, i + 3);
                if (sub.charAt(0) == sub.charAt(2) && sub.charAt(0) != sub.charAt(1)) {
                    invertedBABs.add("" + sub.charAt(1) + sub.charAt(0) + sub.charAt(1));
                }
            }
        }

        for (String s : nonBracketed) {
            for (int i = 0; i <= s.length() - 3; i++) {
                String sub = s.substring(i, i + 3);
                if(sub.charAt(0) == sub.charAt(2) && sub.charAt(0) != sub.charAt(1)) {
                    ABAs.add(sub);
                }
            }
        }

        ABAs.retainAll(invertedBABs);

        if(ABAs.size() > 0) {
            return true;
        }

        return false;
    }
}
