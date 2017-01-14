package challenges.second;

import utils.FileReader;

/**
 * Created by jani on 12/23/16.
 */
public class Challenge23 {

    String[] data;

    public Challenge23() {
        FileReader reader = new FileReader();
        data = reader.readFile("resources/2016/challenge23.txt");
    }

    public int returnValue() {

        int value = 0;

        for (int i = 0; i < data.length; i++) {

        }

        return value;
    }
}
