package racingcar;

import racingcar.controller.CommandLineController;
import racingcar.controller.Controller;
import racingcar.view.game.CarRaceGame;
import racingcar.view.game.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new CarRaceGame();
        Controller controller = new CommandLineController(game);
        controller.start();
    }
}
