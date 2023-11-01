package racingcar.model;

import static java.util.Objects.isNull;
import static racingcar.common.exception.ErrorMessage.EMPTY_NAME;
import static racingcar.common.exception.ErrorMessage.NAME_TOO_LONG;
import static racingcar.common.exception.ErrorMessage.NULL_NAME;

import racingcar.common.exception.CarException;
import racingcar.util.RandomUtil;

public class Car implements Comparable<Car> {

    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final int MIN_RANDOM_VALUE_TO_MOVE = 4;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    private final String name;
    private Integer movedCount;

    private Car(final String name) {
        validateEmptyName(name);
        validateNameLength(name);
        this.name = name;
        this.movedCount = 0;
    }

    public static Car from(final String name) {
        return new Car(name);
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

    @Override
    public int compareTo(Car cmpCar) {
        return cmpCar.getMovedCount()- this.getMovedCount();
    }

    private boolean canMove() {
        return RandomUtil.generateRandomValue(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) >= MIN_RANDOM_VALUE_TO_MOVE;
    }

    private void validateNameLength(final String name) {
        if(name.length() > MAX_LENGTH_OF_NAME) throw new CarException(NAME_TOO_LONG);
    }

    private void validateEmptyName(final String name) {
        if(isNull(name)) throw new CarException(NULL_NAME);
        if(name.isBlank()) throw new CarException(EMPTY_NAME);
    }
}
