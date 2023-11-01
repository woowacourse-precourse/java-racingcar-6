package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarGameController racingCarGameController = new RacingCarGameController(inputView,outputView);
        racingCarGameController.run();
    }
}
