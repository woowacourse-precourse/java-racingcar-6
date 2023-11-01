package racingcar.util;

import static racingcar.constant.Constants.MAX_CAR_NAME_LEN;
import static racingcar.constant.Constants.MIN_CAR_NAME_LEN;
import static racingcar.constant.ExceptionMessage.DUPLICATED_CAR_NAME;
import static racingcar.constant.ExceptionMessage.INVALID_TRIAL_NUMBER;
import static racingcar.constant.ExceptionMessage.LENGTH_OUT_OF_RANGE_CAR_NAME;
import static racingcar.constant.ExceptionMessage.NOT_ALLOWED_WORDS_CAR_NAME;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void checkValidCarNames(String[] carNameGroup) {
        if (!isValidLength(carNameGroup)) {
            throw new IllegalArgumentException(LENGTH_OUT_OF_RANGE_CAR_NAME);
        }

        if (hasDuplicates(carNameGroup)) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME);
        }

        if (!isValidNames(carNameGroup)) {
            throw new IllegalArgumentException(NOT_ALLOWED_WORDS_CAR_NAME);
        }
    }

    public static void checkValidTrialNumber(String trialNum) {
        if (!isValidTrialNumber(trialNum)) {
            throw new IllegalArgumentException(INVALID_TRIAL_NUMBER);
        }
    }

    private static boolean isValidLength(String[] strings) {
        for (String element : strings) {
            if (element.length() < MIN_CAR_NAME_LEN || element.length() > MAX_CAR_NAME_LEN) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicates(String[] strings) {
        Set<String> set = new HashSet<>();

        for (String element : strings) {
            if (!set.add(element)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValidNames(String[] strings) {
        for (String element : strings) {
            if (!element.matches("^[0-9a-zA-Z가-힣_]+$")) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidTrialNumber(String trialNum) {
        return trialNum.matches("^[1-9][0-9]*$");
    }
}
