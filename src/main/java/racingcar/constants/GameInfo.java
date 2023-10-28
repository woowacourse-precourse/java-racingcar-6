package racingcar.constants;

public class GameInfo {
    public static final String SEPARATOR = ",";
    public static final String SEPARATOR_NAME = "쉼표";
    public static final int MIN_CAR_NAME_LENGTH = 1;
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static String CAR_NAME_REGEX = "^[^\\s,]{1,5},[^\\s,]{1,5},[^\\s,]{1,5}$";
}
