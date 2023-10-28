package racingcar.domain;

public class RacingConfig {
    public static final String NAME_SEPARATOR = ",";
    public static final String NAME_PATTERN = "^([a-zA-Z\\p{IsHangul}]+,)*[a-zA-Z\\p{IsHangul}]+$";
    public static final int MAX_LENGTH = 5;
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int FORWARD_NUMBER = 4;
}
