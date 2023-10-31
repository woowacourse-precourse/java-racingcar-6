package racingcar;

import racingcar.controller.MainController;
import racingcar.controller.subcontroller.DetermineWinnerController;
import racingcar.controller.subcontroller.InitializeCarController;
import racingcar.controller.subcontroller.MoveCarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        InitializeCarController initializeCarController = new InitializeCarController(inputView, outputView);
        MoveCarController moveCarController = new MoveCarController(inputView, outputView);
        DetermineWinnerController determineWinnerController = new DetermineWinnerController(inputView, outputView);

        MainController mainController = new MainController(
                inputView, outputView, initializeCarController, moveCarController, determineWinnerController
        );
        mainController.start();
    }
}
