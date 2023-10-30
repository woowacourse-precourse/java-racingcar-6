package racingcar;

import racingcar.controller.Controller;
import racingcar.controller.RacingGameController;
import racingcar.util.InputValidator;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = Validator.generateInputValidator();
        InputView inputView = View.generateInputView(inputValidator);

        OutputView outputView = View.generateOutputView();

        RacingGameController racingGameController = Controller.generateRacingGameController(inputView, outputView);
        racingGameController.gameStart();
    }
}
