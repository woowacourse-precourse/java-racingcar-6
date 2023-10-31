package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int finalRound;
    private int currentRound;

    public RacingGame(int finalRound, List<String> carNames) {
        carNames.stream()
                .map(Car::new)
                .forEach(cars::add);
        this.finalRound = finalRound;
        this.currentRound = 0;
    }

    public void nextRound() {
        currentRound++;
    }

    public boolean isFinalRound() {
        return currentRound >= finalRound;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}
