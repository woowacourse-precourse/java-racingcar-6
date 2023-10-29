package racingcar.controller;

import racingcar.model.CarList;
import racingcar.model.validator.CarNameValidator;
import racingcar.model.validator.RoundNumValidator;
import racingcar.view.InputView;

public class InputController {

    public static CarList initCarList() { // 익셉션 처리 필요
        CarNameValidator carNameValidator = new CarNameValidator(InputView.inputCarNames());
        return new CarList(carNameValidator.getCarNames());
    }

    public static int initRoundNum() {
        return new RoundNumValidator(InputView.inputRoundNum()).getRoundNum();
    }
}
