package racingcar;

import racingcar.component.controller.GameController;
import racingcar.component.service.Inputter;
import racingcar.component.service.Printer;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                Inputter.getInputter(),
                Printer.getPrinter()
        );

        gameController.startGame();
    }
}
