package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private final RacingGame racingGame = new RacingGame();
    private final RacingGameView racingGameView = new RacingGameView();

    public void ready() {
        racingGameView.raceStartMessage();
        final String carNames = racingGameView.getInputLine();

        racingGame.createCarsAfterValidation(carNames);

        racingGameView.raceCountMessage();
        final String raceCount = racingGameView.getInputLine();

        racingGame.setRaceCountAfterValidation(raceCount);
    }

    public void play() {
        final String raceResults = racingGame.race();
        racingGameView.raceResults(raceResults);

        final String winners = racingGame.getWinners();
        racingGameView.winners(winners);
    }
}
