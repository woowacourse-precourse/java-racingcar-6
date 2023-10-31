package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.view.OutputView;

public class GameRunner {
    private final OutputView outputView;
    private final RandomMoveStrategy randomMoveStrategy;

    public GameRunner(OutputView outputView, RandomMoveStrategy randomMoveStrategy) {
        this.outputView = outputView;
        this.randomMoveStrategy = randomMoveStrategy;
    }

    public void runRounds(Cars cars, int rounds) {
        outputView.printExecutionResult();
        for (int i = 0; i < rounds; i++) {
            cars.moveAll(randomMoveStrategy);
            outputView.printCarStatus(cars.getStatus());
        }
    }
}
