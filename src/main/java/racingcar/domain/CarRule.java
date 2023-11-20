package racingcar.domain;

public enum CarRule {
    CAR_NAME_MIN_SIZE(5),
    CAR_LOCATION_INIT(0),
    CAR_LOCATION_STEP(1),
    CAR_MOVE_MINIMUM(4);

    private final int number;

    CarRule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
