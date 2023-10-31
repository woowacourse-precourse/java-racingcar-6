package racingcar.controller;

import racingcar.util.validator.Validator;
import racingcar.view.View;

public interface Controller {
    static RacingGameController generateRacingGameController() {
        Validator inputValidator = Validator.generateInputValidator();
        View inputView = View.generateInputView(inputValidator);
        View outputView = View.generateOutputView();

        return new RacingGameController(inputView, outputView);
    }

    void gameStart();
}
