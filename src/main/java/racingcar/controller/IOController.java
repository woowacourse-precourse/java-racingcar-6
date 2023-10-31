package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.GameRuleValidator;
import racingcar.view.IOView;

public final class IOController {
    private final IOView ioView;
    private final InputValidator inputValidator;

    public IOController() {
        this.ioView = new IOView();
        inputValidator = new InputValidator();
    }

    public void showIntroMessage() {
        ioView.showSingleMessage(GameMessage.INTRO_MESSAGE.toString());
    }

    public void showRequestRoundNumberMessage() {
        ioView.showSingleMessage(GameMessage.ASK_ROUND_MESSAGE.toString());
    }

    public Integer getRoundNumber() {
        String userInput = ioView.readUserInput();
        inputValidator.validateSingleNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public List<String> getCarNames() {
        String userInput = ioView.readUserInput();
        List<String> carNames = parseIntoCarNames(userInput);
        GameRuleValidator.validateNames(carNames);
        return carNames;
    }

    private List<String> parseIntoCarNames(final String givenInput) {
        inputValidator.validateNamesByDelimiter(givenInput, GameMessage.DELIMITER.toString());
        return Arrays.asList(givenInput.split(GameMessage.DELIMITER.toString()));
    }

    public void showRoundResult(final List<String> message) {
        ioView.showMessages(message);
    }

    public void showWinner(final List<String> message) {
        ioView.showHeadMessage(GameMessage.WINNER_HEAD_MESSAGE.toString());
        String winnerNames = message.toString().replace("[", "")
                .replace("]", "");
        ioView.showSingleMessage(winnerNames);
    }
}
