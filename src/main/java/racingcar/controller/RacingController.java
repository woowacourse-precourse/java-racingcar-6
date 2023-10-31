package racingcar.controller;

import racingcar.model.Racing;
import racingcar.model.RacingCars;
import racingcar.model.number.RandomNumberGenerator;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final Racing racing;

    public RacingController() {
        RacingCars cars = getRacingCars();
        String count = InputView.roundCountInput();
        this.racing = new Racing(cars, count);
    }

    public void start() {
        OutputView.printResultMessage();
        playGame();
        OutputView.printResult(racing.getWinners());
    }

    private void playGame() {
        while (racing.isNotFinished()) {
            racing.playRound(new RandomNumberGenerator());
            OutputView.printRoundResult(racing.getStatus());
        }
    }

    private static RacingCars getRacingCars() {
        String[] validateCars = Validator.carNameValidator(InputView.carNamesInput());
        return RacingCars.createCars(validateCars);
    }
}