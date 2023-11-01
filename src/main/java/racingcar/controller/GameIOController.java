package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.rule.GameRuleValidator;
import racingcar.view.ConsoleView;

public final class GameIOController implements IOController {
    private final ConsoleView ioView;
    private final FrontValidator inputValidator;

    public GameIOController(ConsoleView ioView, FrontValidator inputValidator) {
        this.ioView = ioView;
        this.inputValidator = inputValidator;
    }

    @Override
    public void showIntroMessage() {
        ioView.showSingleMessage(GameIOMessage.INTRO_MESSAGE.getMessage());
    }

    @Override
    public void showRequestRoundNumberMessage() {
        ioView.showSingleMessage(GameIOMessage.ASK_ROUND_MESSAGE.getMessage());
    }

    @Override
    public Integer getRoundNumber() {
        String userInput = ioView.readUserInput();
        inputValidator.validateSingleNumber(userInput);
        Integer roundNumber = Integer.parseInt(userInput);
        GameRuleValidator.validateRoundNumber(roundNumber);
        return roundNumber;
    }

    @Override
    public List<String> getCarNames() {
        String userInput = ioView.readUserInput();
        List<String> carNames = parseIntoCarNames(userInput);
        GameRuleValidator.validateNames(carNames);
        return carNames;
    }

    private List<String> parseIntoCarNames(final String givenInput) {
        inputValidator.validateNamesByDelimiter(givenInput, GameIOMessage.INPUT_DELIMITER.toString());
        return Arrays.asList(givenInput.split(GameIOMessage.INPUT_DELIMITER.toString()));
    }

    @Override
    public void showRoundResult(final List<String> message) {
        ioView.showMessages(message);
    }

    @Override
    public void showWinner(final List<String> message) {
        ioView.showHeadMessage(GameIOMessage.WINNER_HEAD_MESSAGE.toString());
        String winnerNames = String.join(GameIOMessage.OUTPUT_DELIMITER.toString(), message);
        ioView.showSingleMessage(winnerNames);
    }
}
