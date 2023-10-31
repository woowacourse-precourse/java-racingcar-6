package racingcar;

import racingcar.game.GameController;
import racingcar.io.ConsoleInputReader;

public class Application {

    public static void main(String[] args) {
        GameController controller = new GameController(new ConsoleInputReader());
        controller.setup();
        controller.start();
    }
}

