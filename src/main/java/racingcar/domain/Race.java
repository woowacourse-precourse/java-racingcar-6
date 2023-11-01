package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int rounds;
    private int currentRound;

    public Race(List<String> carNames, int rounds) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.rounds = rounds;
        this.currentRound = 0;
    }

    public void proceedRound() {
        cars.forEach(Car::move);
        currentRound++;
    }

    public RaceResult getCurrentResult() {
        return new RaceResult(cars);
    }

    public boolean isRaceFinished() {
        return currentRound >= rounds;
    }
}
