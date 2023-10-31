package racingcar.car;

import java.util.List;
import racingcar.util.RandomManipulator;

public class CarMover {
    private final RandomManipulator randomManipulator;

    public CarMover(RandomManipulator randomManipulator) {
        this.randomManipulator = randomManipulator;
    }
    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (randomManipulator.isMove()) {
                car.move();
            }
        }
    }
}
