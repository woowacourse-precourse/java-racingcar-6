package racingcar.model.constant;

public enum CarConstant {
    INITIAL_POSITION(0),
    CAR_MOVEABLE_VALUE(4);

    private final int number;

    CarConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
