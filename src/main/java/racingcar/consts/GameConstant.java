package racingcar.consts;

public enum GameConstant {
    MIN_LENGTH_CAR_NAME(1),
    MAX_LENGTH_CAR_NAME(5),
    MIN_NUMBER_TYPES_CAR(2);

    private final int number;


    GameConstant(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }
}
