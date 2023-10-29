package racingcar.model;

import static java.util.Objects.isNull;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final int MIN_RANDOM_VALUE_TO_MOVE = 4;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    private final String name;
    private Integer movedCount;

    public Car(final String name) {
        validateEmptyName(name);
        validateNameLength(name);
        this.name = name;
        this.movedCount = 0;
    }

    public Result move() {
        if(canMove()) movedCount++;
        return new Result(name, movedCount);
    }

    public String getName() {
        return name;
    }

    public Integer getMovedCount() {
        return movedCount;
    }

    private boolean canMove() {
        return generateRandomValue() >= MIN_RANDOM_VALUE_TO_MOVE;
    }

    private int generateRandomValue() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }

    private void validateNameLength(final String name) {
        if(name.length() > MAX_LENGTH_OF_NAME) throw new IllegalArgumentException();
    }

    private void validateEmptyName(final String name) {
        if(isNull(name)) throw new IllegalArgumentException();
        if(name.isBlank()) throw new IllegalArgumentException();
    }
}
