package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private final RacingGame racingGame = new RacingGame();
    private final RacingGameView racingGameView = new RacingGameView();

    public void readyToPlay() {
        racingGameView.raceStartMessage();
        String carNames = getInputLine();

        racingGame.createCars(carNames);

        racingGameView.raceCountMessage();
        String raceCount = getInputLine();

        racingGame.setRaceCount(raceCount);
    }

    public void play() {
        String raceResults = racingGame.race();
        racingGameView.raceResults(raceResults);

        String winners = racingGame.getWinners();
        racingGameView.winners(winners);
    }

    public String getInputLine() {
        return Console.readLine();
    }
}
