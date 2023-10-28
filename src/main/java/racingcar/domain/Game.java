package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.config.GameConfig;
import racingcar.util.NumberGenerator;

public class Game {

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private final int numberOfAttempts;
    private final List<RoundResult> results;

    public Game(NumberGenerator numberGenerator, Cars cars, int numberOfAttempts) {
        validateNumberOfAttempts(numberOfAttempts);
        this.numberGenerator = numberGenerator;
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
        this.results = new ArrayList<>();
    }

    private static void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts <= GameConfig.ATTEMPTS_MIN_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public void moveCars() {
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.moveAll(getMovingNumbers());
            saveResult();
        }
    }

    private List<Integer> getMovingNumbers() {
        return numberGenerator.generate(cars.getSize());
    }

    private void saveResult() {
        results.add(RoundResult.from(cars));
    }

    public List<RoundResult> getResults() {
        return Collections.unmodifiableList(results);
    }

    public List<String> getWinner() {
        return cars.getCarNamesByMaxPosition();
    }
}
