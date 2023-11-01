package racingcar;

import racingcar.controller.GameController;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        GameController controller = new GameController(view);
        controller.startGame();
    }
}
