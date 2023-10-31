package racingcar.controller;

import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private static String readCarNames() {
        OutputView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = InputView.read();
        CarNameValidator.validateForInputString(carNames);

        return carNames;
    }
}
