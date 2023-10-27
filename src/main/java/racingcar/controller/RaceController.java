package racingcar.controller;

import racingcar.view.MessagePrinter;

public class RaceController {
    public RaceController() {
    }

    public void startGame() {
        MessagePrinter.printStartMessage();
        MessagePrinter.printCountMessage();
    }
}
