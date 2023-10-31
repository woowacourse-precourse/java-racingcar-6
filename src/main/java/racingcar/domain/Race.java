package racingcar.domain;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void run() {
        for (int i = 0; i < rounds; i++) {
            runRound();
        }
    }

    private void runRound() {
        for (Car car : cars) {
            car.move();
        }
    }
}
