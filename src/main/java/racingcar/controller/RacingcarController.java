package racingcar.controller;

import racingcar.view.InputHandler;
import racingcar.view.Printer;

public class RacingcarController {

    public static void startRacingcarGame() {
        Printer.printCarChoiceMessage();
        String inputMessage = InputHandler.getInputMessage();
    }

}
