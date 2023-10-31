package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingGame;
import racingcar.model.ValidatePlayerInput;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private RacingGameView racingGameView;
    private ValidatePlayerInput validatePlayerInput;
    private RacingGame racingGame;

    public RacingGameController() {
        this.racingGameView = new RacingGameView();
        this.validatePlayerInput = new ValidatePlayerInput();
        this.racingGame = new RacingGame();
    }

    public void readyToPlay() {
        racingGameView.raceStartMessage();
        String carNamesInputLine = getInputLine();

        racingGame.readyToCars(carNamesInputLine);

        racingGameView.raceCountMessage();
        String raceCountInputLine = getInputLine();

        racingGame.readyToRace(raceCountInputLine);
    }

    public void play() {

        racingGameView.raceResultMessage();

        String raceResult = racingGame.allRacePlay();
        racingGameView.raceResults(raceResult);

        String winners = racingGame.getWinners();
        racingGameView.gameWinners(winners);
    }

    public String getInputLine() {
        return Console.readLine();
    }
}
