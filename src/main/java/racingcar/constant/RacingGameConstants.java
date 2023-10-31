package racingcar.constant;

import java.util.regex.Pattern;

public class RacingGameConstants {
    public static final int CAR_NAME_LENGTH_MIN = 1;
    public static final int CAR_NAME_LENGTH_MAX = 5;

    public static final int MOVABLE_MIN = 0;
    public static final int MOVABLE_MAX = 9;
    public static final int MOVABLE_THRESHOLD = 4;

    public static final String POSITIVE_INTEGER_REGEX = "[1-9][0-9]*";
    public static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile(RacingGameConstants.POSITIVE_INTEGER_REGEX);
}
