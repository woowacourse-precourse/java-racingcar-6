package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Race {

    private static final int MIN_FORWARD_THRESHOLD = 4;
    private static final int FORWARD_COUNT = 1;

    public void runOneRound(final Cars cars) {
        for (Car car : cars.cars()) {
            int randomValue = RandomNumberGenerator.generateRandomNumber();
            if (randomValue >= MIN_FORWARD_THRESHOLD) {
                car.forward(FORWARD_COUNT);
            }
        }
    }
}
