package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.GameRuleValidator;
import racingcar.view.IOView;

public final class IOController {
    private final IOView ioView;
    InputValidator inputValidator;

    public IOController() {
        this.ioView = new IOView();
        inputValidator = new InputValidator();
    }

    public void showIntroMessage() {
        String introMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        ioView.showSingleMessage(introMessage);
    }

    public void showRequestRoundNumberMessage() {
        String askRoundMessage = "시도할 회수는 몇회인가요?";
        ioView.showSingleMessage(askRoundMessage);
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
        String delimiter = ",";
        inputValidator.validateNamesByDelimiter(givenInput, delimiter);
        return Arrays.asList(givenInput.split(delimiter));
    }

    public void showRoundResult(final List<String> message) {
        ioView.showMessages(message);
    }

    public void showWinner(final List<String> message) {
        String winnerHeadMessage = "최종 우승자 : ";
        ioView.showHeadMessage(winnerHeadMessage);
        String winnerNames = message.toString().replace("[", "")
                .replace("]", "");
        ioView.showSingleMessage(winnerNames);
    }
}
