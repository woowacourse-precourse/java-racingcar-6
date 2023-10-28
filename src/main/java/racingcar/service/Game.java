package racingcar.service;

import racingcar.domain.validation.InputValidator;
import racingcar.ui.Message;
import racingcar.ui.input.InputProcessor;
import racingcar.ui.output.OutputProcessor;

public class Game {
    private InputValidator inputValidator = new InputValidator();
    private InputProcessor inputProcessor = new InputProcessor();
    private OutputProcessor outputProcessor = new OutputProcessor();
    private String carNames;
    private String tryCount;

    public void playGame() {

    }

    private String getInput(String message) {
        outputProcessor.printMessage(message);
        return inputProcessor.readInput();
    }
    private void initCarNames() {
        carNames = getInput(Message.START_MESSAGE_CAR_NAMES.getMessage());
        inputValidator.validateCarNames(carNames);
    }

    private void initTryCount() {
        tryCount = getInput(Message.START_MESSAGE_TRY_COUNT.getMessage());
        inputValidator.validateTryCount(tryCount);
    }
}
