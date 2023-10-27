package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Race;
import racingcar.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = new Race();
        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        GameController gameController = new GameController(race, consoleOutputView);
        gameController.runGame();
    }
}
