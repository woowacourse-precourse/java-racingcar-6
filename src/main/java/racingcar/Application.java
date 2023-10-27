package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController(new InputView(), new OutputView());
        controller.doGame();
    }
}
