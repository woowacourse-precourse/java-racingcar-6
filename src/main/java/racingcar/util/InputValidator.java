package racingcar.util;

import java.util.Arrays;
import java.util.regex.Pattern;
import racingcar.model.CarModel;

public class InputValidator {
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    public boolean hasEmptyCarName(String[] names) {
        for (String name : names) {
            if (name.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean isNaturalNumber(String number) {
        return Pattern.matches(REGEXP_PATTERN_NUMBER, number);
    }

    public boolean isDuplicate(String[] names) {
        return names.length != Arrays.stream(names).distinct().count();

    }
}
