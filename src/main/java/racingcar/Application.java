package racingcar;

import racingcar.controller.Game;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        new Game(new InputView());
    }
}
