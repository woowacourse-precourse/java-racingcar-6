package racingcar.utill;

import java.util.regex.Pattern;

public class ValidatorConstant {
    public static final int CAR_NAME_MAX_SIZE = 5;

    public static final Pattern NATURAL_NUMBER_PATTERN = Pattern.compile("^[1-9][0-9]*$");
}
