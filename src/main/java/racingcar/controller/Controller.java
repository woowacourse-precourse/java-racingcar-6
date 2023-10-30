package racingcar.controller;

import racingcar.util.InputValidator;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.View;

public interface Controller {
    static RacingGameController generateRacingGameController() {
        Validator inputValidator = Validator.generateInputValidator();
        View inputView = View.generateInputView(inputValidator);
        View outputView = View.generateOutputView();

        return new RacingGameController((InputView) inputView, (OutputView) outputView);
    }

    void gameStart();
}
