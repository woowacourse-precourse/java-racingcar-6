package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(INPUT_VIEW, OUTPUT_VIEW);
        gameController.setupGame();
        gameController.play();
    }
}
