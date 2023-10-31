package racingcar.model;

import racingcar.RacingUtil;
import racingcar.model.wrapper.CarName;

public class Car {
    private static final int MIN_MOVE_POWER = 4;
    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        position = 0;
    }

    public void move() {
        position++;
    }

    public void moveAttempt() {
        int power = RacingUtil.generateRandomPower();
        if (isMovablePower(power)) {
            move();
        }
    }

    public boolean isMovablePower(int power) {
        return power >= MIN_MOVE_POWER;
    }

    public String getName() {
        return name.name();
    }

    public int getPosition() {
        return position;
    }
}
