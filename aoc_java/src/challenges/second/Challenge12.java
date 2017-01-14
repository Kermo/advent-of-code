package challenges.second;

import utils.FileReader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jani on 12/12/2016.
 */
public class Challenge12 {

    public String[] data;
    Map<String, Integer> variables = new HashMap<>();

    public Challenge12() {
        FileReader reader = new FileReader();
        data = reader.readFile("resources/2016/challenge12.txt");

        variables.put("a", 0);
        variables.put("b", 0);
        variables.put("c", 0);
        variables.put("d", 0);

    }

    public int valueOfA() {

        for (int i = 0; i < data.length; i++) {
            String[] splittedData = data[i].split(" ");

            if (splittedData[0].equals("cpy")) {
                try {
                    int x = Integer.parseInt(splittedData[1]);
                    variables.put(splittedData[2], x);

                } catch (Exception e) {
                    variables.put(splittedData[2], variables.get(splittedData[1]));
                }

            } else if (splittedData[0].equals("jnz")) {
                try {
                    int x = Integer.parseInt(splittedData[1]);

                    if (x != 0) {
                        i += Integer.parseInt(splittedData[2]) - 1;
                    }

                    if (i > data.length) {
                        break;
                    }
                } catch (Exception e) {
                    int x = variables.get(splittedData[1]);
                    if (x != 0) {
                        i += Integer.parseInt(splittedData[2]) - 1;
                    }

                    if (i > data.length) {
                        break;
                    }
                }

            } else if (splittedData[0].equals("inc")) {
                variables.put(splittedData[1], variables.get(splittedData[1]) + 1);

            } else if (splittedData[0].equals("dec")) {
                variables.put(splittedData[1], variables.get(splittedData[1]) - 1);

            }
        }

        return variables.get("a");
    }

    public int valueOfAAfterC() {
        variables.put("c", 1);
        return valueOfA();
    }
}
