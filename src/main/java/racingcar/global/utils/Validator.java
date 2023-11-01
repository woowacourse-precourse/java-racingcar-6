package racingcar.global.utils;

import static racingcar.global.constant.ErrorMessage.NAME_FORMAT_ERROR_MESSAGE;
import static racingcar.global.constant.ErrorMessage.NAME_LENGTH_ERROR_MESSAGE;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validateCarName(List<String> nameList) {
        for (String name : nameList) {
            validateIfItIsEnglish(name);
            validateLength(name);
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
