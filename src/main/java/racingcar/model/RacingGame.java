package racingcar.model;

import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final NumberGenerator numberGenerator;
    private final int maxTryCount;

    private final Cars cars;
    private int tryCount;

    public RacingGame(int maxTryCount, NumberGenerator numberGenerator, List<String> names) {
        this.numberGenerator = numberGenerator;
        this.cars = createCars(names);
        this.maxTryCount = maxTryCount;
        this.tryCount = 0;
    }

    private Cars createCars(List<String> names) {

        return null;
    }
}
