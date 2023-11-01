package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.Score;
import racingcar.view.RacingGameView;

import java.util.List;

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
        final List<List<Score>> raceResults = racingGame.race();
        racingGameView.raceResults(raceResults);

        final List<String> winners = racingGame.getWinners();
        racingGameView.winners(winners);
    }
}
