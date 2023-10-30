package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.RacingCarGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarController carController = new CarController();

        RacingCarGameController gameController = new RacingCarGameController(inputView, outputView, carController);
        gameController.play();
    }
}
