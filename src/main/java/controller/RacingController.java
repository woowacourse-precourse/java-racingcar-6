package controller;

import service.UserInput;
import view.MessagePrinter;

public class RacingController {

    public void run() {
        inputCarNames();
    }

    public void inputCarNames(){
        MessagePrinter.start();
        UserInput.CarNames();
    }

}
