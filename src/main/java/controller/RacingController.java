package controller;

import service.UserInput;
import view.MessagePrinter;
import service.Cars;

public class RacingController {
    private Cars cars;
    private int times;

    public void run() {
        inputCarNames();
        inputRacingTimes();
        racing();
        winner();
    }

    public void inputCarNames(){
        MessagePrinter.start();
        cars = UserInput.CarNames(UserInput.Input());
    }

    public void inputRacingTimes(){
        MessagePrinter.inputTimes();
        times = UserInput.Times(UserInput.Input());
    }

    public void racing(){
        MessagePrinter.result();
        for(int i=0;i<times;i++){
            cars.go();
            MessagePrinter.racing(cars);
        }
    }

    public void winner(){
        MessagePrinter.winner(cars.determineWinner());
    }

}
