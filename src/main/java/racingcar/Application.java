package racingcar;

import java.util.ArrayList;
import racingcar.Controller.GameController;
import racingcar.Model.GameModel;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GameController gameController = new GameController(new GameModel(), new ArrayList<>());

        gameController.gameStart();
        gameController.gamePlay();
        gameController.findWinner();
        gameController.endGame();
    }
}
