package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.io.InputReader;
import racingcar.io.OutputPrinter;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        OutputPrinter outputPrinter = new OutputPrinter();
        GameController gameController = new GameController(inputReader, outputPrinter);
        gameController.run();
    }
}
