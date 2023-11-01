package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.AutoMoveChecker;
import racingcar.domain.RandomNumberGenerator;
import racingcar.io.InputReader;
import racingcar.io.OutputWriter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = getGameController();
        gameController.start();
    }

    private static GameController getGameController() {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        InputView inputView = new InputView(reader, writer);
        OutputView outputView = new OutputView(writer);
        AutoMoveChecker autoMoveChecker = new AutoMoveChecker(new RandomNumberGenerator());
        return new GameController(inputView, outputView, autoMoveChecker);
    }
}
