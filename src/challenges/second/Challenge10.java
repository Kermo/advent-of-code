package challenges.second;

import utils.FileReader;

import java.util.*;

/**
 * Created by jani on 10/12/2016.
 */
public class Challenge10 {

    public String[] dataArray;
    Map<Integer, Bot> bots = new HashMap<>();
    List<Instruction> instructions = new ArrayList<>();
    public int sum = 0;

    int id1 = 61;
    int id2 = 17;


    public Challenge10() {
        FileReader reader = new FileReader();
        dataArray = reader.readFile("resources/2016/challenge10.txt");
    }

    public int solveBot() {

        for (int i = 0; i < dataArray.length; i++) {
            String row = dataArray[i];

            String[] splittedRow = row.split(" ");

            if (row.contains("value")) {
                instructions.add(new Instruction(getValue(splittedRow, 5), getValue(splittedRow, 1)));
            } else {
                int botId = Integer.valueOf(splittedRow[1]);
                Bot bot = bots.get(botId);
                if (bot == null) {
                    bot = new Bot(botId);
                }
                bot.setAction(getValue(splittedRow, 6), getValue(splittedRow, 11));
                bots.put(botId, bot);
            }
        }

        List<Integer> output = new ArrayList<>();
        Map<Integer, Set<Integer>> hasHandled = new HashMap<>();

        for (Instruction instruction : instructions) {
            bots.get(instruction.botId).addValue(instruction.value);

            while (true) {
                final boolean[] hasPerformed = {false};
                bots.values().stream()
                        .filter(bot -> bot.getValues().size() == 2)
                        .forEach(bot -> {
                            hasPerformed[0] = true;
                            int lowValue = bot.getLowValue();
                            int highValue = bot.getHighValue();

                            Set<Integer> handled = hasHandled.get(bot.getId());

                            if (handled == null) {
                                handled = new HashSet<>();
                            }
                            handled.add(lowValue);
                            handled.add(highValue);
                            hasHandled.put(bot.getId(), handled);

                            if (bot.getLowId() > -1) {
                                bots.get(bot.getLowId()).addValue(lowValue);
                            } else if (bot.getLowId() > -4) {
                                output.add(lowValue);
                            }
                            if (bot.getHighId() > -1) {
                                bots.get(bot.getHighId()).addValue(highValue);
                            } else if (bot.getHighId() > -4) {
                                output.add(highValue);
                            }
                            bot.clear();
                        });
                if (!hasPerformed[0]) {
                    break;
                }
            }
        }

        Integer key = hasHandled.entrySet()
                .stream().filter(k ->
                    k.getValue().contains(id1)
                        && k.getValue().contains(id2))
                .findFirst()
                .get().getKey();

        sum = output.stream().reduce(1, (a, b) -> a * b);

        return key;
    }

    public int countSum() {
        return sum;
    }


    public class Bot {

        private final int id;
        List<Integer> values = new ArrayList<>();

        int lowId;
        int highId;

        public Bot(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public Bot addValue(int value) {
            values.add(value);
            return this;
        }

        public Bot setAction(int lowId, int highId) {
            this.lowId = lowId;
            this.highId = highId;
            return this;
        }

        public List<Integer> getValues() {
            return values;
        }

        public int getLowValue() {
            if (values.get(0) > values.get(1)) {
                return values.get(1);
            }
            return values.get(0);
        }

        public int getHighValue() {
            if (values.get(0) > values.get(1)) {
                return values.get(0);
            }
            return values.get(1);
        }

        public int getLowId() {
            return lowId;
        }

        public int getHighId() {
            return highId;
        }

        public void clear() {
            this.values.clear();
        }
    }

    public class Instruction {

        int botId;
        int value;

        public Instruction(int botId, int value) {
            this.botId = botId;
            this.value = value;
        }
    }


    public int getValue(String[] split, int i) {
        int i1 = Integer.parseInt(split[i]);

        if (split[i - 1].equals("output")) {
            return -i1 - 1;
        } else {
            return i1;
        }
    }

}
