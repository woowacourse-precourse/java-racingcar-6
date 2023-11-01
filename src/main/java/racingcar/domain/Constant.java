package racingcar.domain;

public class Constant {
    public static final String NUMBER_FORMAT = "\\d+";
    public static final String PLAYER_NAMES_FORMAT = "^[^,]+(,[^,]+)+$";
    public static final int MINIMUM_RANDOM_NUMBER = 0;
    public static final int MAXIMUM_RANDOM_NUMBER = 9;
    public static final int DEFAULT_RACE_COUNT = 0;
    public static final int MINIMUM_RACE_COUNT = 1;
    public static final int DEFAULT_DISTANCE = 0;
    public static final int MAXIMUM_PLAYER_NAME_LENGTH = 5;
    public static final String PLAYER_NAMES_DELIMITER = ",";
    public static final String PLAYER_NAMES_DELIMITER_NAME = "쉼표";

    private Constant() {
    }
}
