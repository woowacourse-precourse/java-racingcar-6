package racingcar;

import racingcar.controller.CarGameController;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;
import racingcar.service.CarGameService;
import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {

        final InputHandler inputHandler = new ConsoleInput();
        final OutputHandler outputHandler = new ConsoleOutput();
        final CarGameService carGameService = new CarGameService();

        new CarGameController(inputHandler, outputHandler, carGameService).run();
    }
}
