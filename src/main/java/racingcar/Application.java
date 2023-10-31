package racingcar;

import racingcar.controller.GameController;
import racingcar.model.GameModel;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        GameModel model = null;
        GameController gameController = new GameController(view, model);
        gameController.start();
    }
}