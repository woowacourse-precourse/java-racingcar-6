package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new Game(new GameService(), new InputView(), new OutputView()).doGame();

    }
}
