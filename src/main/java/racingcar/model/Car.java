package racingcar.model;

import static racingcar.model.ActionType.GO;

import racingcar.util.RandomNumberGenerator;
import racingcar.vo.CarName;
import racingcar.vo.CarPosition;

public class Car {

    private static final Integer START_POINT = 0;
    private static final Integer THRESHOLD = 4;

    private final CarName carName;
    private CarPosition carPosition;

    protected Car(final CarName carName) {
        this.carName = carName;
        this.carPosition = new CarPosition(START_POINT);
    }

    public void updatePosition() {
        if (isMovingRequired()) {
            Integer newPosition = getCarPosition().position() + GO.getAction();
            this.carPosition = new CarPosition(newPosition);
        }
    }

    private boolean isMovingRequired() {
        Integer randomNumber = RandomNumberGenerator.pickNumber();
        if (randomNumber >= THRESHOLD) {
            return true;
        }
        return false;
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }
}
