package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.CarListService;
import racingcar.view.Output;
import racingcar.view.UserInput;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new UserInput(), new Output(), new CarListService());
        gameController.gameStart();
    }
}