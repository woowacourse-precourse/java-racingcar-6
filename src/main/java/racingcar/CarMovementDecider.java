package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.randomvalue.RandomValueGenerator;

public class CarMovementDecider {

    private static final int FORWARD_MOVE_THRESHOLD = 4;
    private final RandomValueGenerator randomValueGenerator;

    public CarMovementDecider(RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    public void move(List<Car> carList) {
        for (Car car : carList) {
            if (canMoveForward()) {
                car.moveForward();
            }
        }
    }

    private boolean canMoveForward() {
        return randomValueGenerator.generate() >= FORWARD_MOVE_THRESHOLD;
    }
}
