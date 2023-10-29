package racingcar.domain;

import java.util.HashMap;
import racingcar.util.RandomNumberGenerator;

public class Racing {
    private static final int MIN_FORWARD_VALUE = 4;
    private final Cars cars;
    private final long attempCount;
    private final RandomNumberGenerator randomNumberGenerator;

    public Racing(Cars cars, long attemptCount, RandomNumberGenerator randomNumberGenerator) {
        this.cars = cars;
        this.attempCount = attemptCount;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void race() {
        HashMap<String, Integer> carPositions = cars.getCars();
        carPositions.forEach(this::moveCarIfMovable);
    }

    private void moveCarIfMovable(String car, Integer position) {
        int randomValue = pickRandomNumber();
        if (isMovable(randomValue)) {
            cars.moveCar(car);
        }
    }

    private int pickRandomNumber() {
        return randomNumberGenerator.generate();
    }

    private boolean isMovable(int randomValue) {
        return randomValue >= MIN_FORWARD_VALUE;
    }

    public long getAttempCount() {
        return attempCount;
    }
}


