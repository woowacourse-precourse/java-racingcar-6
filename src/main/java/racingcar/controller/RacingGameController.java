package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingGameService;
import racingcar.model.ValidatePlayerInput;
import racingcar.view.RacingGameView;

import java.util.List;

public class RacingGameController {
    private RacingGameView racingGameView;
    private ValidatePlayerInput validatePlayerInput;
    private RacingGameService racingGameService;
    private List<String> carNames;
    private int raceCount;

    public RacingGameController() {
        this.racingGameView = new RacingGameView();
        this.validatePlayerInput = new ValidatePlayerInput();
        this.racingGameService = new RacingGameService();
    }

    public void validatePlayerInputLine() {
        racingGameView.raceStartMessage();
        String carNamesInputLine = getInputLine();

        this.carNames = validatePlayerInput.validateCarNames(carNamesInputLine);

        racingGameView.raceCountMessage();
        String raceCountInputLine = getInputLine();

        this.raceCount = validatePlayerInput.validateRaceCount(raceCountInputLine);
    }

    public void play() {
        racingGameService.readyToPlay(carNames);

        racingGameView.raceResultMessage();

        String raceResult = racingGameService.allRacePlay(raceCount);
        racingGameView.raceResults(raceResult);

        String winners = racingGameService.getWinners();
        racingGameView.gameWinners(winners);
    }

    public String getInputLine() {
        return Console.readLine();
    }
}
