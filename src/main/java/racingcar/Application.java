package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.utill.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator validator = new Validator();
        InputView inputView = new InputView(validator);
        OutputView outputView = new OutputView();
        RacingCarGameController racingCarGameController = new RacingCarGameController(inputView,outputView);
        racingCarGameController.run();
    }
}
