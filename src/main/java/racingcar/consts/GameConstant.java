package racingcar.consts;

public enum GameConstant {
    MIN_LENGTH_CAR_NAME(1),
    MAX_LENGTH_CAR_NAME(5),
    MIN_NUMBER_ATTEMPT(1);

    private final int number;

    GameConstant(int number) {
        this.number = number;
    }
}
