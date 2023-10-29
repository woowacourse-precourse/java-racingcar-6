package racingcar.model;

import static racingcar.Constants.MAX_RANDOM_NUMBER;
import static racingcar.Constants.MIN_RANDOM_NUMBER;
import static racingcar.Constants.MOVE_CONDITION;

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
        final int random = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return random >= MOVE_CONDITION;
    }

}
