package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.ValidatePlayerInput;
import racingcar.view.GameViewer;

import java.util.List;

public class RacingGameController {
    private GameViewer gameViewer = new GameViewer();
    private ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();

    public void play() {
        gameViewer.startMessage();
        String carNames = getInputLine();
        validatePlayerInput.validateContainSpace(carNames);
        validatePlayerInput.validateCarNameLength(carNames);
        validatePlayerInput.validateDuplicateCarNames(carNames);
        validatePlayerInput.validateAlphaCarName(carNames);
        List<String> names = validatePlayerInput.convertStringToListCarNames(carNames);

        gameViewer.tryCountMessage();
        String tryCount = getInputLine();
        validatePlayerInput.validatePlayerTryCountInput(tryCount);

        gameViewer.gameResultMessage();
        gameViewer.racingResultViewer(names, tryCount);
        gameViewer.gameWinnerViewer();
    }

    public String getInputLine() {
        return Console.readLine();
    }
}
