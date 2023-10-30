package racingcar.controller;

import racingcar.domain.Validator;
import racingcar.view.InputView;

public class RacingCarGame {

    public RacingCarGame() {
    }

    public void play() {
        String carNames = InputView.getCarNames();
        Validator validator = new Validator();
        validator.validateCarNamesInput(carNames);
    }

}
