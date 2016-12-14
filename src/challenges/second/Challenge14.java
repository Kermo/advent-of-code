package challenges.second;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jani on 14.12.2016.
 */
public class Challenge14 {

    private static String salt = "ngcjuoqr";
    private static HashMap<Integer, String> hashes;
    String hash;

    public boolean IS_PART_TWO = false;

    private static final String CHARS3 = "(.)\\1\\1";
    private static final String CHARS5 = "(.)\\1\\1\\1\\1";
    private static final Pattern chars3Pattern = Pattern.compile( CHARS3 );
    private static final Pattern chars5Pattern = Pattern.compile( CHARS5 );

    public int findLastIndes() {
        int foundKeys = 0;
        int index = 0;

        hashes = new HashMap<Integer, String>();

        while (foundKeys != 64) {
            String hash = "";
            if (hashes.containsKey(index)) {
                hash = hashes.get(index);
            } else {
                hash = computeHash(index);
                hashes.put(index, hash);
            }

            Matcher chars3Matcher = chars3Pattern.matcher(hash);

            if (chars3Matcher.find()) {
                Character ch = chars3Matcher.group(1).charAt(0);

                if (ch != null) {
                    String futureHash = "";
                    boolean found = false;

                    for (int i = index + 1; i < index + 1000 && !found; i++) {
                        if (hashes.containsKey(i)) {
                            futureHash = hashes.get(i);
                        } else {
                            futureHash = computeHash(i);
                            hashes.put(i, futureHash);
                        }

                        Matcher chars5Matchers = chars5Pattern.matcher(futureHash);

                        if (chars5Matchers.find()) {
                            Character futureCh = chars5Matchers.group(1).charAt(0);

                            if (ch.equals(futureCh)) {
                                foundKeys += 1;
                                found = true;
                            }

                        }
                    }
                }

            }
            index += 1;
        }
        return index - 1;
    }

    private String computeHash( int index ) {
        try {
            String seed = String.format( "%s%d", salt, index );
            MessageDigest md = MessageDigest.getInstance( "MD5" );
            byte[] digest = md.digest( seed.getBytes( "UTF-8" ) );

            hash = byteArrToHexString( digest );

            if ( IS_PART_TWO ) {
                for ( int i = 0; i < 2016; i++ ) {
                    digest = md.digest( hash.getBytes( "UTF-8" ) );
                    hash = byteArrToHexString( digest );
                }
            }

            return hash;
        } catch ( UnsupportedEncodingException uee ) {
            uee.printStackTrace();
        } catch ( NoSuchAlgorithmException nsae ) {
            nsae.printStackTrace();
        }

        return "";
    }

    public int findLastIndesWithExtra() {
        IS_PART_TWO = true;
        return findLastIndes();
    }

    private static String byteArrToHexString( byte[] bytes ) {
        StringBuilder hexString = new StringBuilder();

        for ( int i = 0; i < bytes.length; i++ ) {
            String hex = Integer.toHexString( 0xFF & bytes[i] );

            if ( hex.length() == 1 ) {
                hexString.append( '0' );
            }

            hexString.append( hex );
        }

        return hexString.toString();
    }
}
