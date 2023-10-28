package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Input;
import racingcar.model.Race;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = new Race();
        Input input = new Input();
        GameController gameController = new GameController(race, input);
        gameController.runGame();
    }
}
