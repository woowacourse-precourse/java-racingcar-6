package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;
    private static final int MOVABLE_RANDOM_NUMBER = 4;
    private static final String NAME_POSITION_DELIMITER = " : ";

    private final Name name;
    private final Position position;

    public Car(final Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void move() {
        final int randomNumber = generateRandomNumber();

        if (!isMovable(randomNumber)) {
            return;
        }

        position.increase();
    }

    @Override
    public String toString() {
        return name + NAME_POSITION_DELIMITER + position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position.compareTo(other.position);
    }

    public boolean isSamePosition(final Car other) {
        return this.position.equals(other.position);
    }

    public CarDto toCarDto() {
        return new CarDto(name, position);
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    }

    private boolean isMovable(final int randomNumber) {
        return randomNumber >= MOVABLE_RANDOM_NUMBER;
    }
}
