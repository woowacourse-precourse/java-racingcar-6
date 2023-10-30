package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

public class Race {

    private static final int MIN_FORWARD_THRESHOLD = 4;
    private static final int ONE_STEP = 1;

    public void runOneRound(final Cars cars) {
        for (Car car : cars.cars()) {
            int randomValue = generateRandomValue();
            forwardIfThresholdMet(car, randomValue);
        }
    }

    private static int generateRandomValue() {
        return RandomNumberGenerator.generateRandomNumber();
    }

    private static void forwardIfThresholdMet(Car car, int randomValue) {
        if (randomValue >= MIN_FORWARD_THRESHOLD) {
            car.forward(ONE_STEP);
        }
    }
}
