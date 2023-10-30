package racingcar;

import java.util.List;

public class RoundService {
    private static final int START_RANDOM_NUMBER = 0;
    private static final int END_RANDOM_NUMBER = 9;

    private static final int FORWARD_CRITERIA = 4;
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
