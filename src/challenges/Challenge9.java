package challenges;

import utils.FileReader;

import java.util.*;

/**
 * Created by jani on 12/12/15.
 */
public class Challenge9 {

    public String[] data;

    public Challenge9() {

        FileReader reader = new FileReader();
        data = reader.readFile("resources/challenge9.txt");
    }

    public int countShortestRoute() {
        int shortestDistance = 0;

        List<Integer> totalDistances = new ArrayList<Integer>();
        List<String> cities = new ArrayList<String>();
        HashMap<String, Integer> distances = new HashMap<String, Integer>();


        for (int i = 0; i < data.length; i++) {

            String[] citiesAndDistance = data[i].split(" = ");
            String[] city = citiesAndDistance[0].split(" to ");

            if (!cities.contains(city[0])) {
                cities.add(city[0]);
            }

            if (!cities.contains(city[1])) {
                cities.add(city[1]);
            }
        }

        return shortestDistance;
    }
}
