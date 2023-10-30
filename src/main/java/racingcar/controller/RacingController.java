package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.number.RandomNumberGenerator;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final Racing racing;

    public RacingController() {
        String[] validateCars = Validator.carNameValidator(InputView.carNamesInput());
        Cars cars = Cars.createCars(validateCars);
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
}