package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.InputController;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new InputController(), new OutputView());
        gameController.play();
    }
}