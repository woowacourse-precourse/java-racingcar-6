package racingcar;

import racingcar.controller.MainController;
import racingcar.model.manager.CarMoveManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(InputView.getInstance(), OutputView.getInstance(), new CarMoveManager());
        mainController.play();
    }
}
