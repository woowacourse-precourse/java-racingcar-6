package racingcar.controller;

import java.util.List;
import racingcar.model.CarList;
import racingcar.model.validator.impl.CarNameValidator;
import racingcar.model.validator.impl.RoundNumValidator;
import racingcar.view.InputView;

public class InputController {

    public static CarList initCarList() {
        CarNameValidator carNameValidator = new CarNameValidator(InputView.inputCarNames());
        return new CarList((List<String>) carNameValidator.getValidatedInput());
    }

    public static int initRoundNum() {
        return (int) new RoundNumValidator(InputView.inputRoundNum()).getValidatedInput();
    }
}
