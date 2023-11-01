package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.view.ResultView;

public class RacingGame {
    private final Cars cars;
    private final int totalRounds;
    private final ResultView resultView;

    private RacingGame(final RacingGameConfig config, final MoveStrategy moveStrategy) {
        cars = new Cars(config.getCarNames(), moveStrategy);
        totalRounds = config.getTotalRounds();
        this.resultView = config.getResultView();
    }

    public static RacingGame createWithRandomMove(final RacingGameConfig config) {
        return new RacingGame(config, new RandomMoveStrategy());
    }

    public void play() {
        resultView.printRaceStart();
        for (int i = 0; i < totalRounds; i++) {
            cars.moveAllCars();
            resultView.printRoundResult(cars.getAllCars());
        }
    }

    public Cars getCars() {
        return cars;
    }
}
