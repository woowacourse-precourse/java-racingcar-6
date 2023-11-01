package racingcar.global.utils;

import static racingcar.global.constant.ErrorMessage.NAME_FORMAT_ERROR_MESSAGE;
import static racingcar.global.constant.ErrorMessage.NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.global.constant.ErrorMessage.TRIAL_FORMAT_ERROR_MESSAGE;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String ZERO = "0";

    public static boolean validateCarName(List<String> nameList) {
        for (String name : nameList) {
            validateIfItIsEnglish(name);
            validateLength(name);
        }
        return true;
    }

    public static boolean validateTrialNumber(String trial) {
        if (!trial.matches("^(0|[1-9]+[0-9]*)$") || trial.equals(ZERO)) {
            throw new IllegalArgumentException(TRIAL_FORMAT_ERROR_MESSAGE);
        }
        return true;
    }

    private static boolean validateIfItIsEnglish(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.find()) {
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
