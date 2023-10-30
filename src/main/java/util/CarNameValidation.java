package util;

import java.util.HashSet;
import model.Car;

public class CarNameValidation {

    public static void checkCarNameValidation(String[] carNameList) {
        if (!CarNameValidation.isDuplicate(carNameList) || !CarNameValidation.checkCarNameLength(carNameList)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicate(String[] carNameList) {
        HashSet<String> setCarNameList = insertCarName(carNameList);
        return setCarNameList.size() == carNameList.length;
    }

    private static HashSet<String> insertCarName(String[] carNameList) {
        HashSet<String> setCarNameList = new HashSet<>();
        for (String carName : carNameList) {
            setCarNameList.add(carName);
        }
        return setCarNameList;
    }

    private static boolean checkCarNameLength(String[] carList) {
        for (String carName : carList) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;

    }
}
