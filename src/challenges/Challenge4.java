package challenges;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by jani on 04/12/15.
 */
public class Challenge4 {

    public String secretKey = "bgvyzdsv";

    public int MD5Hash() {

        String key = "";
        String hash = "";
        int suffixNumber = 1;

        while(!key.startsWith("000000")) {
            suffixNumber++;

            hash = secretKey + Integer.toString(suffixNumber);

            byte[] bytes = hash.getBytes();

            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] theDigest = messageDigest.digest(bytes);
                key = (new HexBinaryAdapter()).marshal(messageDigest.digest(bytes));

            } catch (Exception e) {
                System.out.println("MD5 hash failed");
            }
        }

        return suffixNumber;
    }
}
