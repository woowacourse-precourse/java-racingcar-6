package racingcar.controller;

import racingcar.model.CarValidation;
import racingcar.model.RacingCars;
import racingcar.model.RoundNumValidator;
import racingcar.view.InputView;

public class InputController {

    public static RacingCars getCarNames() {
        CarValidation validation = new CarValidation(InputView.carInput());
        return new RacingCars(validation.carNames);
    }

    public static int getRoundCount() {
        RoundNumValidator roundNumValidator = new RoundNumValidator(InputView.roundInput());
        return Integer.parseInt(roundNumValidator.roundNumString());
    }
}
