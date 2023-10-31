package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.utils.InputValidator;
import racingcar.utils.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingCarService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingCarService();
    }

    public void racingGameStart() {
        String input = InputView.inputCarsName();
        List<String> cars = Arrays.asList(input.split(","));
        racingGameService.registerCars(cars);

        String moveCountStr = InputView.inputMovesCount();
        InputValidator.validateEmptyInput(moveCountStr);
        int moveCount = InputValidator.validateNonNumeric(moveCountStr);
        InputValidator.validateNegativeInput(moveCount);

        playGame(moveCount);
        displayWinners();
    }

    private void playGame(int moveCount) {
        System.out.println(Message.EXECUTION_RESULT_MESSAGE.getMessage());
        while (moveCount-- > 0) {
            racingGameService.moveCar();
            System.out.println();
        }
    }

    private void displayWinners() {
        OutputView.printFinalWinner(racingGameService.findWinners());
    }
}
