package racingcar.controller;

import racingcar.model.CarValidation;
import racingcar.model.RacingCars;
import racingcar.model.RoundNumValidator;
import racingcar.view.InputView;

public class InputController {

    public static RacingCars getCarNames() {
        String userInput = InputView.carInput();
        CarValidation validation = new CarValidation(userInput);
        return new RacingCars(validation.carNames);
    }


    public static int getRoundCount() {
        String roundInput = InputView.roundInput();
        RoundNumValidator roundNumValidator = new RoundNumValidator(roundInput);
        return Integer.parseInt(roundNumValidator.roundNumString());
    }
}
