package racingcar.service.utils;

import java.util.List;

public class InputValidatorUtils {
    public boolean isValidateCarInput(List<String> input) {
        for (String elem : input) {
            if (elem.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
