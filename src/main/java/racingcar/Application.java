package racingcar;

import racingcar.printer.OutputPrinter;

public class Application {

    public static void main(String[] args) {
        OutputPrinter outputPrinter = new OutputPrinter();
        GameManager gameManager = new GameManager(outputPrinter);
        gameManager.playGame();
    }
}
