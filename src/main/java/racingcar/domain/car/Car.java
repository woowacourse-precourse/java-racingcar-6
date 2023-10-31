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

    public void move(int randomNumber) {
        if (isMovable(randomNumber)) {
            distance += MOVEMENT_DISTANCE.getNumber();
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVEMENT_CONDITION_NUMBER.getNumber();
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
        return String.format("%s : %s", name.getName(), "-".repeat(distance));
    }

}