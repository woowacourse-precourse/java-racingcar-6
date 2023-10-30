package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.PrintComment;

public class RacingCarController {
    private Car car;

    public RacingCarController(){
        car = new Car();
    }
    public void game(){
        PrintComment.printInitComment();
        car.carsSet();
        PrintComment.printTrialComment();
        car.trialSet();
    }
}
