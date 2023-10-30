package racingcar;

import racingcar.controller.GameController;
import racingcar.view.Output;
import racingcar.view.UserInput;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new UserInput(), new Output());
        gameController.gameStart();
    }
}