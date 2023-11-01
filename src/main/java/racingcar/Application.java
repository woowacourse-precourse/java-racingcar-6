package racingcar;

import racingcar.controller.InputController;
import racingcar.controller.MainController;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MainController mainController = new MainController(new InputController(), new OutputView());
        mainController.run();
    }
}
