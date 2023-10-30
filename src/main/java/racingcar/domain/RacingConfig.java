package racingcar.domain;

public class RacingConfig {
    private RacingConfig() {
        throw new AssertionError("RacingConfig class should not be instantiated.");
    }
    public static final String NAME_SEPARATOR = ",";
    public static final String NAME_PATTERN = "^([a-zA-Z\\p{IsHangul}]+,)*[a-zA-Z\\p{IsHangul}]+$";
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MOVE_FORWARD_VALUE = 4;
    public static final String MOVED_HISTORY_MARK = "-";
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
}
