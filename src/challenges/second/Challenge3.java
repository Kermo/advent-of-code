package challenges.second;

import utils.FileReader;

import java.io.IOException;

/**
 * Created by jani on 03/12/2016.
 */
public class Challenge3 {

    String[] data;
    String[] dataArray;
    int amountOfValidTriangles;
    boolean isValidTriangle = true;

    public Challenge3() {

        FileReader fileReader = new FileReader();
        data = fileReader.readFile("resources/2016/challenge3.txt");

    }

    public int countValidTriangles() {

        for(int i = 0; i < data.length; i++) {
            isValidTriangle = true;
            dataArray = data[i].split("\\s+");

            if (Integer.valueOf(dataArray[1]) + Integer.valueOf(dataArray[2]) <= Integer.valueOf(dataArray[3])) {
                isValidTriangle = false;
            }
            if (Integer.valueOf(dataArray[2]) + Integer.valueOf(dataArray[3]) <= Integer.valueOf(dataArray[1])) {
                isValidTriangle = false;
            }
            if (Integer.valueOf(dataArray[3]) + Integer.valueOf(dataArray[1]) <= Integer.valueOf(dataArray[2])) {
                isValidTriangle = false;
            }

            if(isValidTriangle) {
                amountOfValidTriangles++;
            }
        }

        return amountOfValidTriangles;
    }

    public int countValidTrianglesFromColumns() {

        String[] fColumn = new String[data.length];
        String[] sColumn = new String[data.length];
        String[] tColumn = new String[data.length];
        amountOfValidTriangles = 0;

        for(int i = 0; i < data.length; i++) {
            dataArray = data[i].split("\\s+");

            fColumn[i] = dataArray[1];
            sColumn[i] = dataArray[2];
            tColumn[i] = dataArray[3];
        }

        for(int i = 0; i < data.length; i = i + 3) {

            isValidTriangle = true;

            if (Integer.valueOf(fColumn[i]) + Integer.valueOf(fColumn[i + 1]) <= Integer.valueOf(fColumn[i + 2])) {
                isValidTriangle = false;
            }
            if (Integer.valueOf(fColumn[i + 1]) + Integer.valueOf(fColumn[i + 2]) <= Integer.valueOf(fColumn[i])) {
                isValidTriangle = false;
            }
            if (Integer.valueOf(fColumn[i + 2]) + Integer.valueOf(fColumn[i]) <= Integer.valueOf(fColumn[i + 1])) {
                isValidTriangle = false;
            }

            if(isValidTriangle) {
                amountOfValidTriangles++;
            }

            isValidTriangle = true;

            if (Integer.valueOf(sColumn[i]) + Integer.valueOf(sColumn[i + 1]) <= Integer.valueOf(sColumn[i + 2])) {
                isValidTriangle = false;
            }
            if (Integer.valueOf(sColumn[i + 1]) + Integer.valueOf(sColumn[i + 2]) <= Integer.valueOf(sColumn[i])) {
                isValidTriangle = false;
            }
            if (Integer.valueOf(sColumn[i + 2]) + Integer.valueOf(sColumn[i]) <= Integer.valueOf(sColumn[i + 1])) {
                isValidTriangle = false;
            }

            if(isValidTriangle) {
                amountOfValidTriangles++;
            }

            isValidTriangle = true;

            if (Integer.valueOf(tColumn[i]) + Integer.valueOf(tColumn[i + 1]) <= Integer.valueOf(tColumn[i + 2])) {
                isValidTriangle = false;
            }
            if (Integer.valueOf(tColumn[i + 1]) + Integer.valueOf(tColumn[i + 2]) <= Integer.valueOf(tColumn[i])) {
                isValidTriangle = false;
            }
            if (Integer.valueOf(tColumn[i + 2]) + Integer.valueOf(tColumn[i]) <= Integer.valueOf(tColumn[i + 1])) {
                isValidTriangle = false;
            }

            if(isValidTriangle) {
                amountOfValidTriangles++;
            }

        }

        return amountOfValidTriangles;
    }
}