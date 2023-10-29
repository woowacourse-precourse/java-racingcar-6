package racingcar.global;

public enum RacingCarGameConfig {
    CAR_NAME_MAX_LENGTH(5),
    RANDOM_MAX_NUMBER(9),
    RANDOM_MIN_NUMBER(1),
    STANDARD_NUMBER(4);

    private final int value;

    RacingCarGameConfig(int value) {
        this.value = value;
    }
}
