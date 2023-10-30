package controller;

import service.UserInput;
import view.MessagePrinter;
import vo.Cars;

public class RacingController {

    public void run() {
        inputCarNames();
    }

    public void inputCarNames(){
        MessagePrinter.start();
        Cars cars = UserInput.CarNames();
    }

}
