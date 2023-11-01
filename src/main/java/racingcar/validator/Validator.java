package racingcar.validator;

import static racingcar.constant.GameConstants.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void isLessThanFiveLetter(String carName) {
        if (carName.length() <= 5) {
            return;
        }
        String returnString = String.format(NAME_IS_MORE_THAN_FIVE_LETTER,carName);
        throw new IllegalArgumentException(returnString);
    }

    public static void isEmptyString(String input) {
        if (input == null || input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_SHOULD_NOT_BE_NULL);
        }
    }


    public static void checkCarNamesForm(String carNames) {
        String regularExpForInput = "[^,]+,(?:[^,]+,)*[^,]+";
        if (!carNames.matches(regularExpForInput)) {
            throw new IllegalArgumentException(CAR_NAMES_FORM_IS_WRONG);
        }
    }
    public static void checkCarNameDuplication(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException(CAR_NAME_IS_DUPLICATED);
        }
    }


    public static void isNumber(String input) {
        String regularExpForInput = "\\d+";
        if (!input.matches(regularExpForInput)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    public static void isMoreThanOne(String attemptNumberString) {
        int attemptNumber = Integer.parseInt(attemptNumberString);
        if (attemptNumber >= 1) {
            return;
        }
        String returnString = String.format(ATTEMPT_NUMBER_SHOULD_BE_MORE_THAN_ONE,attemptNumber);
        throw new IllegalArgumentException(returnString);
    }

    public static void randomNumberRange(int num) {
        if (MIN_NUM <= num && num <= MAX_NUM) {
            return;
        }
        String returnString = String.format(RANDOM_NUMBER_RANGE_IS_OUT_OF_RANGE,num);
        throw new IllegalArgumentException(returnString);
    }

}
