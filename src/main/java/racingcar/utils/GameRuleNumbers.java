package racingcar.utils;

import java.util.regex.Pattern;

public class GameRuleNumbers {
    public static int RANDOM_NUMBER_MIN = 0;
    public static int RANDOM_NUMBER_MAX = 9;
    public static int FORWARD_CONDITION = 4;
    public static int NAME_LENGTH_LIMIT = 5;
    public static final Pattern NUMBER_FORMAT = Pattern.compile("^(0|[-]?[1-9]\\d*)$");
}
