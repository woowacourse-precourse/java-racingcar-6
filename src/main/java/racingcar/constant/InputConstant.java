package racingcar.constant;

public enum InputConstant {

    CAR_NAME_LIMIT(5),
    MIN_PARTICIPANT(2),
    MAX_PARTICIPANT(10),
    MIN_NUMBER_OF_RACE(1),
    MAX_NUMBER_OF_RACE(20);

    private final int value;

    InputConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
