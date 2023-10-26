package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.handler.InputHandler;
import racingcar.view.ConsoleInput;

public class Application {
    public static void main(String[] args) {

        final InputHandler inputHandler = new ConsoleInput();

        new RacingCarGameController(inputHandler).run();
    }
}
