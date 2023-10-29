package racingcar;

import racingcar.Controller.CarController;
import racingcar.Controller.GameController;
import racingcar.Model.GameModel;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GameController gameController = new GameController(new GameModel(),new CarController());

        gameController.gameStart();
    }
}
