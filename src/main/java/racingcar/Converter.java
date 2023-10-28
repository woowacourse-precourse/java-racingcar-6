package racingcar;

import java.util.ArrayList;

public class Converter {
    public static ArrayList<String> convertStringToList(String carsName) {
        String[] carsNameArray = carsName.split(",");
        ArrayList<String> carsNameList = new ArrayList<>();
        for(String carName : carsNameArray) {
            carsNameList.add(carName);
        }
        return carsNameList;
    }

}
