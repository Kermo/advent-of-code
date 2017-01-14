package challenges.first;

import utils.FileReader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jani on 07/12/15.
 */
public class Challenge7 {

    public String[] data;

    public Challenge7() {
        FileReader reader = new FileReader();
        data = reader.readFile("resources/2015/challenge7.txt");
    }

    public int providedSignal() {
        Map<String, Integer> map = new HashMap<String, Integer>();


        String[] logicOperations = {"AND", "OR", "NOT", "RSHIFT", "LSHIFT"};

        while(!map.containsKey("a")) {


            for(int i = 0; i < data.length; i++) {

                if(!data[i].equals("executed")) {

                    String[] actorSignals;
                    String[] inputSignals;
                    String operation = "";
                    boolean operationFound = false;

                    actorSignals = data[i].split("->");

                    String outputSignal = actorSignals[1].replaceAll("[^0-9a-z?!\\.,]", "");

                    for (int j = 0; j < logicOperations.length; j++) {
                        if (actorSignals[0].contains(logicOperations[j])) {
                            operation = logicOperations[j];
                            operationFound = true;
                            break;
                        }
                    }

                    if (operationFound) {
                        if (operation.equals("RSHIFT") || operation.equals("LSHIFT")) {
                            operation += " " + actorSignals[0].split(" ")[2];
                            inputSignals = actorSignals[0].split(operation);
                            inputSignals[0] = inputSignals[0].replaceAll("[^0-9a-z?!\\.,]", "");

                            String[] shift = operation.split(" ");
                            shift[1] = shift[1].replaceAll("[^0-9?!\\.,]", "");

                            if (map.containsKey(inputSignals[0])) {
                                if (shift[0].contains("RSHIFT")) {
                                    int rshiftValue = map.get(inputSignals[0]) >> Integer.parseInt(shift[1]);
                                    map.put(outputSignal, rshiftValue);
                                    data[i] = "executed";
                                } else if (shift[0].contains("LSHIFT")) {
                                    int lshiftValue = map.get(inputSignals[0]) << Integer.parseInt(shift[1]);
                                    map.put(outputSignal, lshiftValue);
                                    data[i] = "executed";
                                }
                            }
                        } else if (operation.equals("NOT")) {
                            inputSignals = actorSignals[0].split(operation);
                            inputSignals[1] = inputSignals[1].replaceAll("[^0-9a-z?!\\.,]", "");

                            if (map.containsKey(inputSignals[1])) {
                                int notValue = ~map.get(inputSignals[1]);
                                map.put(outputSignal, 65536 + notValue);
                                data[i] = "executed";
                            }
                        } else if (operation.equals("AND") || operation.equals("OR")) {
                            inputSignals = actorSignals[0].split(operation);
                            inputSignals[0] = inputSignals[0].replaceAll("[^0-9a-z?!\\.,]", "");
                            inputSignals[1] = inputSignals[1].replaceAll("[^0-9a-z?!\\.,]", "");

                            if (operation.equals("AND")) {
                                if(!isNumeric(inputSignals[0])) {
                                    if (map.containsKey(inputSignals[0]) && map.containsKey(inputSignals[1])) {
                                        int andValue = map.get(inputSignals[0]) & map.get(inputSignals[1]);
                                        map.put(outputSignal, andValue);
                                        data[i] = "executed";
                                    }
                                } else {
                                    if (map.containsKey(inputSignals[1])) {
                                        int andValue = Integer.parseInt(inputSignals[0]) & map.get(inputSignals[1]);
                                        map.put(outputSignal, andValue);
                                        data[i] = "executed";
                                    }
                                }
                            } else if (operation.equals("OR")) {
                                if (map.containsKey(inputSignals[0]) && map.containsKey(inputSignals[1])) {
                                    int orValue = map.get(inputSignals[0]) | map.get(inputSignals[1]);
                                    map.put(outputSignal, orValue);
                                    data[i] = "executed";
                                }
                            }
                        }
                    } else {
                        String inputSignal = actorSignals[0].replaceAll("[^0-9a-z?!\\.,]", "");

                        if (isNumeric(inputSignal)) {
                            map.put(outputSignal, Integer.parseInt(inputSignal));
                            data[i] = "executed";
                        } else {
                            if (map.containsKey(inputSignal)) {
                                map.put(outputSignal, map.get(inputSignal));
                                data[i] = "executed";
                            }
                        }
                    }
                }
            }

        }

        return map.get("a");

    }

    public boolean isNumeric(String string) {
        try {
            int i = Integer.parseInt(string);
        } catch(NumberFormatException nfe) {
            return false;
        }

        return true;
    }

}

