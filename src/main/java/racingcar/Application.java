package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final InputView inputview = new InputView();
    private static final OutputView outputview = new OutputView();

    public static void main(String[] args) {
        GameController gameController = new GameController(inputview, outputview);
        gameController.runGame();
    }
}
