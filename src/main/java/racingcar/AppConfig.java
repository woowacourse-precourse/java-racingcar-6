package racingcar;

public class AppConfig {
    public static final int NAME_LENGTH_MIN = 1;
    public static final int NAME_LENGTH_MAX = 5;
    public static final String NAME_FORMAT = String.format("[a-zA-Z]{%d,%d}",NAME_LENGTH_MIN, NAME_LENGTH_MAX);
}
