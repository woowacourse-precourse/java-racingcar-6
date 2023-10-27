package racingcar.controller;

import racingcar.util.InputValidator;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.View;

public class RacingGameController {
    private final InputView inputView;

    RacingGameController() {
        InputValidator inputValidator = Validator.generateInputValidator();
        this.inputView = View.generateInputView(inputValidator);
    }
}
