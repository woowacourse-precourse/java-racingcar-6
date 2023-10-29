package racingcar.domain;

public class RacingConfig {
    private RacingConfig() {
        throw new AssertionError("RacingConfig class should not be instantiated.");
    }
    public static final String NAME_SEPARATOR = ",";
    public static final String NAME_PATTERN = "^([a-zA-Z\\p{IsHangul}]+,)*[a-zA-Z\\p{IsHangul}]+$";
    public static final String FORWARD_HISTORY_MARK = "-";
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int FORWARD_NUMBER = 4;
}
