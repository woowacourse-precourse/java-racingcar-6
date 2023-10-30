package util;

import java.util.ArrayList;
import java.util.HashSet;
import model.Car;

public class CarNameValidation {

    public static void checkCarNameValidation(ArrayList<Car> carNameList) {
        if (!CarNameValidation.isDuplicate(carNameList) || !CarNameValidation.checkCarNameLength(carNameList)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicate(ArrayList<Car> carNameList) {
        HashSet<String> setCarNameList = insertCarName(carNameList);
        return setCarNameList.size() == carNameList.size();
    }

    private static HashSet<String> insertCarName(ArrayList<Car> carNameList) {
        HashSet<String> setCarNameList = new HashSet<>();
        for (Car carName : carNameList) {
            setCarNameList.add(carName.getCarName());
        }
        return setCarNameList;
    }

    private static boolean checkCarNameLength(ArrayList<Car> carList) {
        for (Car carName : carList) {
            if (carName.getCarName().length() > 5) {
                return false;
            }
        }
        return true;

    }
}
