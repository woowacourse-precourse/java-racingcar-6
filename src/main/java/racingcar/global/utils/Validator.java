package racingcar.global.utils;

import static racingcar.global.constant.ErrorMessage.NAME_FORMAT_ERROR_MESSAGE;
import static racingcar.global.constant.ErrorMessage.NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.global.constant.ErrorMessage.TRIAL_FORMAT_ERROR_MESSAGE;

import java.util.List;

public class Validator {

    private static final String ZERO = "0";
    private static final String TRIAL_PATTERN = "^(0|[1-9]+[0-9]*)$";
    private static final String NAME_PATTERN = "^[a-zA-Z]*$";

    public static boolean validateCarName(List<String> nameList) {
        for (String name : nameList) {
            validateIfItIsEnglish(name);
            validateLength(name);
        }
        return true;
    }

    public static boolean validateTrialNumber(String trial) {
        if (!trial.matches(TRIAL_PATTERN) || trial.equals(ZERO)) {
            throw new IllegalArgumentException(TRIAL_FORMAT_ERROR_MESSAGE);
        }
        return true;
    }

    private static boolean validateIfItIsEnglish(String name) {
        if (!name.matches(NAME_PATTERN)) {
            throw new IllegalArgumentException(NAME_FORMAT_ERROR_MESSAGE);
        }
        return true;
    }

    private static boolean validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
        return true;
    }

}
