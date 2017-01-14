package challenges.second;

/**
 * Created by jani on 12/16/16.
 */
public class Challenge16 {

    public int lenght = 272;
    public String input = "10010000000110000";

    public String returnChecksum() {

        String fullLenghtData = null;

        while (input.length() < lenght) {
            input = dragonCurve(input);
        }

        fullLenghtData = input.substring(0, lenght);

        String checksum = fullLenghtData;

        while (checksum.length() % 2 == 0) {
            StringBuilder newChecksum = new StringBuilder();

            for (int j = 0; j < checksum.length(); j += 2) {
                if (checksum.charAt(j) == checksum.charAt(j + 1)) {
                    newChecksum.append("1");
                } else {
                    newChecksum.append("0");
                }

            }
            checksum = newChecksum.toString();

        }

        return checksum;
    }

    public String returnSecondChecksum() {
        lenght = 35651584;
        return returnChecksum();
    }

    public String dragonCurve(String input) {

        String dragonCurveString = null;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            stringBuilder = stringBuilder.append(input.charAt(i) == '0' ? '1' : '0');
        }

        dragonCurveString = input + "0" + stringBuilder.toString();

        return dragonCurveString;
    }
}
