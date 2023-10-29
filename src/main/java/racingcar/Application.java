package racingcar;

import racingcar.controller.MainController;
import racingcar.controller.subcontroller.InitializeCarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InitializeCarController initializeCarController = new InitializeCarController();

        MainController mainController = new MainController(inputView, outputView, initializeCarController);
        mainController.start();
    }
}
