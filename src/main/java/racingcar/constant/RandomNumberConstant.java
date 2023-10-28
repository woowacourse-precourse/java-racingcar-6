package racingcar.constant;

public enum RandomNumberConstant {

    MOVE_FORWARD(4), MINIMUM_PICK_RANDOM_NUMBER(0), MAXIMUM_PICK_RANDOM_NUMBER(9);

    private final int number;

    RandomNumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
