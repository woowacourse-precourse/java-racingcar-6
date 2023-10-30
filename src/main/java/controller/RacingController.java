package controller;


import service.UserInput;
import view.MessagePrinter;
import vo.Cars;

public class RacingController {
    private Cars cars;
    private int times;

    public void run() {
        inputCarNames();
        inputRacingTimes();
    }

    public void inputCarNames(){
        MessagePrinter.start();
        cars = UserInput.CarNames();
    }

    public void inputRacingTimes(){
        MessagePrinter.inputTimes();
        times = UserInput.Times();
    }

}
