package racingcar.controller;

import racingcar.util.Validator;
import racingcar.view.InputView;

public class CarController {
    InputView inputView = new InputView();
    Validator validator = new Validator();

    public void startGame() {
        String input = inputView.carInput();
        validator.convertStringToList(input);
        inputView.roundInput();
    }
}
