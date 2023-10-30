package racingcar;

import racingcar.controller.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new Game(new InputView(), new OutputView()).play();
    }
}
