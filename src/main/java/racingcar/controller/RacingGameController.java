package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarGameMachine;
import racingcar.model.ValidatePlayerInput;
import racingcar.view.GameViewer;

import java.util.List;

public class RacingGameController {
    private GameViewer gameViewer = new GameViewer();
    private ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
    private RacingCarGameMachine racingCarGameMachine = new RacingCarGameMachine();

    public void play() {
        gameViewer.startMessage();
        String inputLine = getInputLine();
        validatePlayerInput.validateContainSpace(inputLine);
        validatePlayerInput.validateCarNameLength(inputLine);
        validatePlayerInput.validateDuplicateCarNames(inputLine);
        validatePlayerInput.validateAlphaCarName(inputLine);
        List<String> carNames = validatePlayerInput.convertStringToListCarNames(inputLine);

        gameViewer.tryCountMessage();
        String tryCount = getInputLine();
        validatePlayerInput.validatePlayerTryCountInput(tryCount);

        racingCarGameMachine.readyToPlay(carNames);
        gameViewer.gameResultMessage();
        for (int i = 0; i < Integer.parseInt(tryCount); i++) {
            racingCarGameMachine.race();
            List<RacingCar> raceResult = racingCarGameMachine.getRacingCars();
            gameViewer.racingCarsMoveStatus(raceResult);
        }

        List<String> winners = racingCarGameMachine.getWinner();
        gameViewer.gameWinners(winners);
    }

    public String getInputLine() {
        return Console.readLine();
    }
}
