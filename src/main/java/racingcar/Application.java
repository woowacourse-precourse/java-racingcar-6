package racingcar;

import java.util.ArrayList;
import racingcar.controller.GameController;
import racingcar.model.CarGame;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new CarGame(new ArrayList<>()));
        gameController.play();
    }
}
