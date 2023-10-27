package racingcar;

import racingcar.component.GameController;
import racingcar.component.Inputter;
import racingcar.component.Printer;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                Inputter.getInputter(),
                Printer.getPrinter()
        );

        gameController.startGame();
    }
}
