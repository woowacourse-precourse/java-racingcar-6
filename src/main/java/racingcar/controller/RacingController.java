package racingcar.controller;

import racingcar.util.validator.InputValidator;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;

    private final InputValidator validator;
    public RacingController() {
        inputView = new InputView();
        validator = new InputValidator();
    }

    public void startGame() {
        validator.isStringEmpty(inputView.printInputCarName());

    }
}
