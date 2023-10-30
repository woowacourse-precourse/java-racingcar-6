package util;

import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Pattern;

public class CarNameValidation {

    public static void checkCarNameValidation(String[] carNameList) {
        if (!isDuplicate(carNameList) || !checkCarNameLength(carNameList) || !isAlpabet(carNameList)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicate(String[] carNameList) {
        HashSet<String> setCarNameList = insertCarName(carNameList);
        return setCarNameList.size() == carNameList.length;
    }

    private static HashSet<String> insertCarName(String[] carNameList) {
        HashSet<String> setCarNameList = new HashSet<>();
        Collections.addAll(setCarNameList, carNameList);
        return setCarNameList;
    }

    private static boolean isAlpabet(String[] carNameList) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        for (String carName : carNameList) {
            if (!pattern.matcher(carName).matches()) {
                return false;
            }
        }
        return true;
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
