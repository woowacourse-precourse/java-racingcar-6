package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameConfig;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceController {
    private final InputView inputView;
    private final ResultView resultView;

    public RaceController(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startRace() {
        List<String> carNames = getCarNames();
        int totalRounds = getTotalRounds();

        RacingGameConfig gameConfig = new RacingGameConfig(carNames, totalRounds, resultView);
        RacingGame racingGame = RacingGame.createWithRandomMove(gameConfig);
        racingGame.play();

        declareWinners(racingGame);
    }

    private List<String> getCarNames() {
        String carNamesString = inputView.readCarNames();
        return List.of(carNamesString.split(","));
    }

    private int getTotalRounds() {
        return inputView.readAttemptCount();
    }

    private void declareWinners(final RacingGame racingGame) {
        Cars cars = racingGame.getCars();
        List<Car> winners = cars.findWinners();
        resultView.printWinners(winners);
    }
}
