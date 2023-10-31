package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Game;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game model = new Game();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
        controller.run();
    }
}