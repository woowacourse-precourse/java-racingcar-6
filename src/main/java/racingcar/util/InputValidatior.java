package racingcar.util;

import java.util.regex.Pattern;

public class InputValidatior {

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";
    private static final int CAR_MIN_NUMBER = 0;

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
}
