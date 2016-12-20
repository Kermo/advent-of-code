package challenges.second;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jani on 12/20/16.
 */
public class Challenge20 {

    String[] data;
    List<List<Long>> blockedRanges = new ArrayList<List<Long>>();
    long lowestIp = -1;
    long validCount = 0;

    public Challenge20() {
        FileReader reader = new FileReader();
        data = reader.readFile("resources/2016/challenge20.txt");
    }

    public long returnMinIP() {

        for (String s : data) {
            List<Long> singleRange = new ArrayList<>();

            for (String edge : s.split("-")) {
                singleRange.add(Long.parseLong(edge));
            }

            blockedRanges.add(singleRange);
        }

        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < blockedRanges.size() - 1; i++) {
                if (blockedRanges.get(i).get(0) > blockedRanges.get(i + 1).get(0)) {
                    List<Long> holder = blockedRanges.get(i);
                    blockedRanges.remove(i);
                    blockedRanges.add(i + 1, holder);
                    sorted = false;
                }
            }
        }

        int startIndex = 0;

        for (long testIp = 0; testIp < 4294967295L; testIp++) {
            boolean inRange = false;

            for (int rangeIndex = startIndex; rangeIndex < blockedRanges.size() && !inRange; rangeIndex++) {
                if (testIp >= blockedRanges.get(rangeIndex).get(0) && testIp <= blockedRanges.get(rangeIndex).get(1)) {
                    inRange = true;
                    startIndex = rangeIndex;
                    testIp = blockedRanges.get(rangeIndex).get(1);
                }
            }

            if (!inRange) {
                if (validCount == 0) {
                    lowestIp = testIp;
                }
                validCount++;
            }
        }

        return lowestIp;
    }

    public long returnValidIpCount() {
        return validCount;
    }
}
