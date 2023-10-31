package racingcar.util;

import java.util.regex.Pattern;

public class InputValidatior {

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";
    private static final int CAR_MIN_NUMBER = 0;

    public boolean isCarNamesUnderLength(String[] names) {
        return names.length <= CAR_MIN_NUMBER;
    }

    public boolean isNaturalNumber(String number) {
        return Pattern.matches(REGEXP_PATTERN_NUMBER, number);
    }
}
