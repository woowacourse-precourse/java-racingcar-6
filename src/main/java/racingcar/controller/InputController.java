package racingcar.controller;

import racingcar.model.Racing;
import racingcar.utils.CarInputValidator;
import racingcar.utils.RoundInputValidator;
import racingcar.view.InputView;

public class InputController {
    public static Racing setRacing() {
        String input = InputView.carInput();
        CarInputValidator.validate(input);
        return new Racing(CarInputValidator.split(input));
    }

    public static int getRound() {
        String input = InputView.roundInput();
        RoundInputValidator.validate(input);
        return Integer.parseInt(input);
    }
}
