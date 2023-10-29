package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.List;

public record Race(Cars cars) {

    private static final int MIN_FORWARD_THRESHOLD = 4;
    private static final int FORWARD_COUNT = 1;

    public void runOneRound() {
        for (Car car : cars.cars()) {
            int randomValue = RandomNumberGenerator.generateRandomNumber();
            if (randomValue >= MIN_FORWARD_THRESHOLD) {
                car.forward(FORWARD_COUNT);
            }
        }
    }

    public List<Car> getCarList() {
        return cars.cars();
    }
}
