package racingcar.constant;

import java.util.regex.Pattern;

public final class RaceConfig {
    public static final int MINIMUM_RANDOM_NUMBER = 0;
    public static final int MAXIMUM_RANDOM_NUMBER = 9;
    public static final int LEAST_VALUE_TO_STEP_FORWARD = 4;
    public static final int STEP_FORWARD_SPACE_COUNT = 1;
    public static final int CAR_NAME_LENGTH_LIMIT = 5;
    public static final int INITIAL_CAR_POSITION = 0;

    public static final String CONVERTING_SIGNS = "-";
    public static final String DELIMITER_WHEN_WINNER_IS_PLURAL = ", ";
    public static final String INPUT_SPLIT_DELIMITER = ",";
    public static final String NUMBER_REGEX = "[0-9]+";

    public static final Pattern IS_NUMBER = Pattern.compile(NUMBER_REGEX);
}
