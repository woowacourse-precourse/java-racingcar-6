package racingcar.validation;

import java.util.HashMap;

import static racingcar.utils.Utils.*;

public final class Validation {

    public static void validateIsNotNull(String inputString){
        if (inputString == null
                || replaceCommaToBlank(inputString).isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateSeparator(String inputString){
        if (!isEqualArray(splitByComma(inputString), splitByCommaAndBlank(inputString))) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarNumber(String[] arr){
        if (arr.length < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarNameLength(String carName){
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarNamesNotDuplicate(HashMap<String,String> hashMap, String carName){
        if (hashMap.keySet().contains(carName)) {
            throw new IllegalArgumentException();
        }
    }

}
