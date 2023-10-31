package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private RacingGame racingGame = new RacingGame();
    private RacingGameView racingGameView = new RacingGameView();

    public void readyToPlay() {
        racingGameView.raceStartMessage();
        String carNamesInputLine = getInputLine();

        racingGame.readyToCars(carNamesInputLine);

        racingGameView.raceCountMessage();
        String raceCountInputLine = getInputLine();

        racingGame.readyToRace(raceCountInputLine);
    }

    public void play() {
        String raceResult = racingGame.allRacePlay();
        racingGameView.raceResults(raceResult);

        String winners = racingGame.getWinners();
        racingGameView.gameWinners(winners);
    }

    public String getInputLine() {
        return Console.readLine();
    }
}
