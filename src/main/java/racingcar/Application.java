package racingcar;

import racingcar.controller.CarGameController;
import racingcar.service.CarGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        CarGameService carGameService = new CarGameService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarGameController carGameController = new CarGameController(carGameService, inputView, outputView);

        carGameController.start();
    }
}
