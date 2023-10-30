package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.validation.InputValidator;
import racingcar.view.ConsoleOutput;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, RacingService racingService) {
        this.inputView = inputView;
        this.racingService = racingService;
    }

    public void run() {
        ConsoleOutput.displayMessage(ConsoleOutput.CAR_NAME_MESSAGE);
        String input = inputView.getCarNames();
        List<String> carNames = racingService.stringToList(input);
        InputValidator.isLengthGreaterThanFive(carNames);

        Cars cars = new Cars(carNames);

        ConsoleOutput.displayMessage(ConsoleOutput.TRY_MESSAGE);
        int tries = inputView.getTries();
        InputValidator.isGreaterThanZero(tries);

        ConsoleOutput.printNewLine();

        ConsoleOutput.displayMessage(ConsoleOutput.ROUND_RESULT_MESSAGE);
        for (int num = 0; num < tries; num++) {
            cars.playGame();
        }
    }
}
