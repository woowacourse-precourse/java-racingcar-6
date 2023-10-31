package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.config.GameConfig.*;

public class Car {

    private Name name;

    private int distance = 0;

    private Car() {

    }

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move() {
        if (isMovable()) {
            distance += MOVEMENT_DISTANCE.getNumber();
        }
    }

    private boolean isMovable() {
        return getRandomNumber() >= MOVEMENT_CONDITION_NUMBER.getNumber();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START.getNumber(), RANDOM_NUMBER_RANGE_END.getNumber());
    }

    public boolean isSameDistanceOrFurtherThan(Car otherCar) {
        return distance >= otherCar.getDistance();
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance;
    }

    public String getMovementString() {
        return String.format("%s : %s", name.toString(), "-".repeat(distance));
    }

    public String getNameString() {
        return name.toString();
    }
}