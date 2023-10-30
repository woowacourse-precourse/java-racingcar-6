package controller;


import camp.nextstep.edu.missionutils.Randoms;
import service.Car;
import service.UserInput;
import view.MessagePrinter;
import vo.Cars;

public class RacingController {
    private Cars cars;
    private int times;

    public void run() {
        inputCarNames();
        inputRacingTimes();
        racing();
    }

    public void inputCarNames(){
        MessagePrinter.start();
        cars = UserInput.CarNames();
    }

    public void inputRacingTimes(){
        MessagePrinter.inputTimes();
        times = UserInput.Times();
    }

    public void racing(){
        MessagePrinter.result();
        for(int i=0;i<times;i++){
            cars.go();
            MessagePrinter.racing(cars);
        }
    }

}
