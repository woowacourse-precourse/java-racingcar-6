package racingcar;

import racingcar.controller.GameController;
import racingcar.model.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(), new OutputView(), new RandomMoveStrategy());
        gameController.run();
    }
}
