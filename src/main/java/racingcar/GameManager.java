package racingcar;

import racingcar.printer.OutputPrinter;

public class GameManager {

    private final OutputPrinter outputPrinter;

    public GameManager(final OutputPrinter outputPrinter) {
        this.outputPrinter = outputPrinter;
    }

    public void playGame() {
        prepareGame();
    }

    private void prepareGame() {
        outputPrinter.printCarNameInputMessage();
    }
}
