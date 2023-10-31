package racingcar.constants;

public enum RacingCarConstants {

    FORWARD_THRESHOLD(4),
    NAME_MAX_LENGTH(5),
    RANDOM_MIN(0),
    RANDOM_MAX(9),
    ROUND_MIN(1),
    ROUND_MAX(100),
    CAR_MIN(1),
    CAR_MAX(10);

    private final int value;

    RacingCarConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
