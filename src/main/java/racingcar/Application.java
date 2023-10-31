package racingcar;

import racingcar.controller.Controller;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        Controller.init(new GameView()).RunGame();
    }
}
