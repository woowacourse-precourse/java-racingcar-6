package racingcar;

import racingcar.controller.GameController;
import racingcar.view.CarView;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController();
        CarView view = new CarView();
        controller.setView(view);
        controller.startGame();
    }
}
