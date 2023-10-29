package racingcar.car;

public class RacingCar {
    private static final Integer MOVE_COUNT_INITIAL_NUMBER = 0;
    private static final Integer MAX_NAME_LENGTH = 5;

    private final String name;
    private final Integer moveCount;

    public RacingCar(String name) {
        validateNameLength(name);
        this.name = name;
        this.moveCount = MOVE_COUNT_INITIAL_NUMBER;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
