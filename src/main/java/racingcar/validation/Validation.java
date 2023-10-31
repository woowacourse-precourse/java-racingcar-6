package racingcar.validation;

import racingcar.view.ErrorMessage;

import java.util.HashMap;

import static racingcar.utils.Utils.*;

public final class Validation {

    public static void validateIsNotNull(String inputString){
        if (inputString == null
                || replaceCommaToBlank(inputString).isBlank()) {
            ErrorMessage.isNotNullError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateSeparator(String inputString){
        if (!isEqualArray(splitByComma(inputString), splitByCommaAndBlank(inputString))) {
            ErrorMessage.separatorError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarNumber(String[] arr){
        if (arr.length < 1) {
            ErrorMessage.carNumberError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarNameLength(String carName){
        if (carName.length() > 5) {
            ErrorMessage.carNameLengthError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarNamesNotDuplicate(HashMap<String,String> hashMap, String carName){
        if (hashMap.keySet().contains(carName)) {
            ErrorMessage.carNamesNotDuplicateError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsDigit(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            ErrorMessage.isDigitError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateTryNumber(String inputString){
        if (stringToInt(inputString) < 0) {
            ErrorMessage.tryNumberError();
            throw new IllegalArgumentException();
        }
    }

}
