package racingcar.car;

import static racingcar.constant.Constants.CONDITION_RANDOM_VALUE;

import java.util.List;
import racingcar.util.RandomManipulator;

public class CarMover {
    private final RandomManipulator randomManipulator;

    public CarMover(RandomManipulator randomManipulator) {
        this.randomManipulator = randomManipulator;
    }
    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randNum = randomManipulator.pickNumber();

            if (isMove(randNum)) {
                car.move();
            }
        }
    }

    private boolean isMove(int randNum) {
        return randNum >= CONDITION_RANDOM_VALUE;
    }
}
