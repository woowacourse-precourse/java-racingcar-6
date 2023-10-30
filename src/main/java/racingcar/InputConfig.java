package racingcar;

public class InputConfig {
    public static final int NAME_LENGTH_MIN = 1;
    public static final int NAME_LENGTH_MAX = 5;
    public static final String NAME_FORMAT = String.format("[a-zA-Z]{%d,%d}",NAME_LENGTH_MIN, NAME_LENGTH_MAX);
    public static final String NAME_DELIMITER = ",";
    public static final int PARTICIPANT_MIN = 2;
    public static final int RACE_INPUT_MIN = 1;
    public static final int RACE_INPUT_MAX = Integer.MAX_VALUE;
}
