package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarGameMachine;
import racingcar.model.ValidatePlayerInput;
import racingcar.view.GameViewer;

import java.util.List;

public class RacingGameController {
    private GameViewer gameViewer;
    private ValidatePlayerInput validatePlayerInput;
    private RacingCarGameMachine racingCarGameMachine;
    private List<String> carNames;
    private int parsedTryCount;

    public RacingGameController() {
        this.gameViewer = new GameViewer();
        this.validatePlayerInput = new ValidatePlayerInput();
        this.racingCarGameMachine = new RacingCarGameMachine();
    }

    public void validatePlayerInputLine() {
        gameViewer.startMessage();
        String inputLine = getInputLine();

        validatePlayerInput.convertStringToArray(inputLine);
        validatePlayerInput.validateContainSpace(inputLine);
        validatePlayerInput.validateNotContainCarNameAndContinuousComma();
        validatePlayerInput.validateCarNameLength();
        validatePlayerInput.validateDuplicateCarNames();
        validatePlayerInput.validateAlphaCarName();

        this.carNames = validatePlayerInput.convertStringToListCarNames();

        gameViewer.tryCountMessage();
        String tryCountInputLine = getInputLine();
        validatePlayerInput.validatePlayerTryCountInput(tryCountInputLine);

        this.parsedTryCount = Integer.parseInt(tryCountInputLine);
    }

    public void play() {
        racingCarGameMachine.readyToPlay(carNames);
        gameViewer.gameResultMessage();
        for (int i = 0; i < parsedTryCount; i++) {
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
