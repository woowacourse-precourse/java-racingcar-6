package racingcar;

import racingcar.controller.CarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarController racingController = new CarController(inputView,outputView );
        racingController.play();
    }
}
