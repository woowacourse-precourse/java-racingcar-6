package racingcar.domain;

import java.util.LinkedHashMap;
import racingcar.util.RandomNumberGenerator;

public class Racing {
    private static final int MIN_FORWARD_VALUE = 4;
    private final Cars cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public Racing(Cars cars, RandomNumberGenerator randomNumberGenerator) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void race() {
        LinkedHashMap<String, Integer> carPositions = cars.getCars();
        carPositions.forEach((car, position) -> {
            if (shouldMoveCar()) {
                cars.moveCar(car);
            }
        });
    }

    private boolean shouldMoveCar() {
        int randomValue = pickRandomNumber();
        return isMovable(randomValue);
    }

    private int pickRandomNumber() {
        return randomNumberGenerator.generate();
    }

    private boolean isMovable(int randomValue) {
        return randomValue >= MIN_FORWARD_VALUE;
    }

}


