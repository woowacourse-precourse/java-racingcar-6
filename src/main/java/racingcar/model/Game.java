package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void run() {
        cars.forEach(this::attemptMoving);
    }

    private void attemptMoving(Car car) {
        if (checkMoving()) {
            car.move();
        }
    }

    private boolean checkMoving() {
        final int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }

}
