package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.config.GameConfig.*;

public class Car {

    protected Name name;

    protected Distance distance;

    private Car() {

    }

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance();
    }

    public void move() {
        if (getRandomNumber() >= MOVEMENT_CONDITION_NUMBER.getNumber()) {
            distance.add(MOVEMENT_DISTANCE.getNumber());
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START.getNumber(), RANDOM_NUMBER_RANGE_END.getNumber());
    }

    public boolean isEqualOrGreaterThan(Car otherCar) {
        return distance.isEqualOrGreaterThan(otherCar);
    }

    public boolean isCarWithMaxDistance(Car carWithMaxDistance) {
        return distance.isCarWithMaxDistance(carWithMaxDistance);
    }

    public String getMovementString() {
        return String.format("%s : %s", name.toString(), distance.toString());
    }

    public String getNameString() {
        return name.toString();
    }
}