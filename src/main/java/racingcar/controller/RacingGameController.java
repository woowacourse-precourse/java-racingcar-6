package racingcar.controller;

import java.util.List;
import racingcar.model.CarSpeedGenerator;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.model.RandomSpeedGenerator;
import racingcar.model.RoundResult;
import racingcar.model.TryCount;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void run() {
        final RacingGame game = createRacingGame();

        game.play(createRacingCars(), createTryCount());

        final List<RoundResult> roundResults = game.getRoundResults();
        OutputView.printRoundResults(roundResults);

        final Winners winners = Winners.from(game.getHighScores());
        OutputView.printWinners(winners);
    }

    private RacingGame createRacingGame() {
        return new RacingGame(createSpeedGenerator());
    }

    private CarSpeedGenerator createSpeedGenerator() {
        return new RandomSpeedGenerator();
    }

    private Cars createRacingCars() {
        return Cars.withNames(InputView.readCarNames());
    }

    private TryCount createTryCount() {
        return TryCount.valueOf(InputView.readNumberOfAttempts());
    }
}
