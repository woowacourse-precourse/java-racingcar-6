package racingcar.service.utils;

import java.util.List;

public class InputValidatorUtils {
    public static boolean isValidateCarInput(List<String> input) {
        for (String elem : input) {
            if (elem.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNum(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
