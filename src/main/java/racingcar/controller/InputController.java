package racingcar.controller;

import racingcar.model.CarValidation;
import racingcar.model.RacingCars;
import racingcar.model.RoundNumValidator;
import racingcar.view.InputView;

public class InputController {

    public static RacingCars getCarNames() {
        while (true) {
            try {
                String userInput = InputView.carInput();
                CarValidation validation = new CarValidation(userInput);
                return new RacingCars(validation.carNames);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    public static int getRoundCount() {
        while (true) {
            try {
                String roundInput = InputView.roundInput();
                RoundNumValidator roundNumValidator = new RoundNumValidator(roundInput);
                return Integer.parseInt(roundNumValidator.roundNumString());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    private static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
