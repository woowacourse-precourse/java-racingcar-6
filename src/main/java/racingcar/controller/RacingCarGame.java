package racingcar.controller;

import racingcar.view.Printer;

public class RacingCarGame {
    private final InputDevice inputDevice = new InputDevice();
    public void run(){
        Printer.printQuestionCars();
        String[] carNames = inputDevice.inputCarNames();
    }
}
