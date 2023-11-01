package racingcar;

import racingcar.controller.GameController;
import racingcar.model.GameFactory;
import racingcar.model.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameFactory gameFactory = new GameFactory(new RandomMoveStrategy());
        GameController gameController = new GameController(new InputView(), new OutputView(), gameFactory);
        gameController.run();
    }
}
