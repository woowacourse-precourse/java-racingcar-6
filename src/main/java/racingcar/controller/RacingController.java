package racingcar.controller;

import java.util.List;
import racingcar.model.GameService;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
import racingcar.view.input.InputView;
import racingcar.controller.validator.UserInputValidator;
import racingcar.view.output.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private final UserInputValidator userInputValidator;

    public RacingController(InputView inputView, OutputView outputView, GameService gameService, UserInputValidator userInputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
        this.userInputValidator = userInputValidator;
    }

    public void playGame() {
        List<String> carNames = getCarNames();
        Integer roundCount = getRoundCount();

        gameService.initializeGame(carNames, roundCount);

        while (!gameService.isGameOver()) {
            RoundResult roundResult = gameService.executeRound();
            outputView.printRoundResult(roundResult);
        }

        Winners winners = gameService.findWinners();
        outputView.printWinner(winners);
    }

    private Integer getRoundCount() {
        return userInputValidator.validateRoundCount(inputView.getRoundCount());
    }

    private List<String> getCarNames() {
        return userInputValidator.validateCarNames(inputView.getCarNames());
    }
}
