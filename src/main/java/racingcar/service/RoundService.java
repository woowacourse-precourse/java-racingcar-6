package racingcar.service;

import static racingcar.constant.Constants.END_RANDOM_NUMBER;
import static racingcar.constant.Constants.FORWARD_CRITERIA;
import static racingcar.constant.Constants.START_RANDOM_NUMBER;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.RandomNumber;

public class RoundService {

    private final RandomNumber randomNumber;

    public RoundService(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void moveCarsByRandom(List<Car> cars) {
        for (Car car : cars) {
            if (randomMoveSelect()) {
                car.moveForward();
            }
        }
    }

    private Boolean randomMoveSelect() {
        int number = randomNumber.randomGenerate(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
        return number >= FORWARD_CRITERIA;
    }
}
