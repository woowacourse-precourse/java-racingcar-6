package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Converter {
    public static String[] convertCarsName(String newCarsName){
        String[] newCarsNameArray = newCarsName.split(",");

        for(int i=0;i< Arrays.stream(newCarsNameArray).count();i++){
            newCarsNameArray[i] = newCarsNameArray[i].replace(" ","");
        }

        return newCarsNameArray;
    }

    public static int convertTurn(String newTurn){
        return Integer.parseInt(newTurn);
    }
}
