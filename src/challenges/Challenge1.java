package challenges;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Challenge1 {

    public String data;

    public Challenge1() {
        try {
            data = new Scanner(new File("resources/challenge1.txt"), "UTF-8").useDelimiter("\\A").next();
        } catch (IOException e) {
            System.out.println("File not found");
        }

    }

    public int countFloor() {
        int floor = 0;

        for(int i = 0; i < data.length(); i++) {
            if(data.charAt(i) == '(') {
                floor++;
            } else {
                floor--;
            }
        }

        return floor;
    }

    public int firstBasementPosition() {
        int position = 0;
        int floor = 0;

        for(int i = 0; i < data.length(); i++) {
            if(data.charAt(i) == '(') {
                floor++;
                position++;
            } else {
                floor--;
                position++;
                if(floor == -1) {
                    break;
                }
            }
        }

        return position;
    }
}
