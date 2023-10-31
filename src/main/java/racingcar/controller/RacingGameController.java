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
    private int parsedTryCount;

    public RacingGameController() {
        this.racingGameView = new RacingGameView();
        this.validatePlayerInput = new ValidatePlayerInput();
        this.racingGameService = new RacingGameService();
    }

    public void validatePlayerInputLine() {
        racingGameView.startMessage();
        String inputLine = getInputLine();

        validatePlayerInput.convertStringToArray(inputLine);
        validatePlayerInput.validateContainSpace(inputLine);
        validatePlayerInput.validateNotContainCarName();
        validatePlayerInput.validateCarNameLength();
        validatePlayerInput.validateDuplicateCarNames();
        validatePlayerInput.validateAlphaCarName();

        this.carNames = validatePlayerInput.convertStringToListCarNames();

        racingGameView.tryCountMessage();
        String tryCountInputLine = getInputLine();
        validatePlayerInput.validatePlayerTryCountInput(tryCountInputLine);

        this.parsedTryCount = Integer.parseInt(tryCountInputLine);
    }

    public void play() {
        racingGameService.readyToPlay(carNames);

        racingGameView.gameResultMessage();

        String result = racingGameService.getAllRaceResult(parsedTryCount);
        racingGameView.gameResults(result);

        String winners = racingGameService.getWinners();
        racingGameView.gameWinners(winners);
    }

    public String getInputLine() {
        return Console.readLine();
    }
}
