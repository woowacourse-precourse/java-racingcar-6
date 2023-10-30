package racingcar.controller;

import racingcar.domain.Validator;
import racingcar.view.InputView;

public class RacingCarGame {

    public RacingCarGame() {
    }

    public void play() {
        Validator validator = new Validator();
        String carNames = InputView.getCarNames();
        validator.validateCarNamesInput(carNames);
        String attempt = InputView.getNumberAttempted();
    }

}
