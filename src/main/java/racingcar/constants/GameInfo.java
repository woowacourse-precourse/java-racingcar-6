package racingcar.constants;

public class GameInfo {
    public static final String SEPARATOR = ",";
    public static final String SEPARATOR_NAME = "쉼표";
    public static final int MIN_CAR_NAME_LENGTH = 1;
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String CAR_NAME_REGEX = "^[0-9a-zA-Z,]+$";
    public static final int MIN_ROUND_NUM = 1;
    public static final int MAX_ROUND_NUM = 999;
    public static final String ROUND_NUM_REGEX = "^[1-9]\\d{0,2}$";
    public static final String WINNER_SEPARATOR = ", ";
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    public static final int MOVE_OR_STOP_CRITERIA = 4;
}
