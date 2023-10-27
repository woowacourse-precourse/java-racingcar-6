package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final int RANDOM_START_INCLUSIVE = 0;
    private final int RANDOM_END_INCLUSIVE = 9;
    private final int CRITICAL_VALUE = 4;
    private final String CURRENT_STATE_FORMAT = "%s : %s";

    private final CarName name;
    private final CarMovement movement;

    public Car(String name) {
        this.name = new CarName(name);
        this.movement = new CarMovement();
    }

    public String name() {
        return name.name();
    }

    public CarMovement movement() {
        return movement;
    }

    public void move() {
        int randomValue = generateRandomValue();
        if (randomValue >= CRITICAL_VALUE) {
            movement.goForward();
        }
    }

    private int generateRandomValue() {
        return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
    }

    public boolean isSameDistance(Car car) {
        return movement.equals(car.movement);
    }

    @Override
    public String toString() {
        return String.format(CURRENT_STATE_FORMAT, name.name(), movement.toString());
    }
}
