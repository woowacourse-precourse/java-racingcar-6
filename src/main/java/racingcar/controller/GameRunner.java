package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class GameRunner {
    private final OutputView outputView;
    private final RandomNumberGenerator randomNumberGenerator;
    private final RandomMoveStrategy randomMoveStrategy;

    public GameRunner(OutputView outputView, RandomNumberGenerator randomNumberGenerator,
                      RandomMoveStrategy randomMoveStrategy) {
        this.outputView = outputView;
        this.randomNumberGenerator = randomNumberGenerator;
        this.randomMoveStrategy = randomMoveStrategy;
    }

    public void runRounds(Cars cars, int rounds) {
        outputView.printExecutionResult();
        for (int i = 0; i < rounds; i++) {
            cars.moveAll(randomNumberGenerator, randomMoveStrategy);
            outputView.printCarStatus(cars.getStatus());
        }
    }
}
