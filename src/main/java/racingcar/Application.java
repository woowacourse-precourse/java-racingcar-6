package racingcar;

import racingcar.controller.GameController;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new Input(), new Output());
        gameController.playGame();
    }
}
