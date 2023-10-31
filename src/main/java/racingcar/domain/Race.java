package racingcar.domain;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private int rounds;
    private int currentRound = 0;

    public Race(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }
}
