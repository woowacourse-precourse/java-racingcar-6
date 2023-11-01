package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.MovingStrategy;
import racingcar.util.RandomNumberUtilImp;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        GameController gameController = new GameController(
                                                        inputView,
                                                        outputView,
                                                        movingStrategy);
        gameController.play();
    }
}
