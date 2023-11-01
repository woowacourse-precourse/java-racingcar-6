package racingcar;

import racingcar.controller.GameController;
import racingcar.model.move.RandomMove;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(InputView.getInputview(), OutputView.getOutputview(),
                new RandomMove());

        gameController.start();
    }
}
