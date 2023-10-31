package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomGenerator;

public class Race {
    private final List<Car> cars;
    private final int tries;

    public Race(List<Car> cars, int tries) {
        this.cars = cars;
        this.tries = tries;
    }

    public void start() {
        for (int i = 0; i < tries; i++) {
            for (Car car : cars) {
                car.move(RandomGenerator.generateRandomNumber());
            }
        }
    }

    public void startOneRound() {
        for (Car car : cars) {
            car.move(RandomGenerator.generateRandomNumber());
        }
    }

    public List<String> getWinners() {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
