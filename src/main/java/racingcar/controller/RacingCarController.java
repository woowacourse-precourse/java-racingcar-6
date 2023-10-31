package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.OutputUserCar;
import racingcar.view.PrintComment;

import java.util.Map;

public class RacingCarController {
    private Car car;

    public RacingCarController(){
        car = new Car();
    }
    public void game(){
        PrintComment.printInitComment();
        car.carsSet();
        PrintComment.printTrialComment();
        int trialNumber = car.trialSet();
        while(trialNumber-- >0){
            Map<String, Integer> situation = car.goFront();
            OutputUserCar.printResultComment();
            OutputUserCar.racingCurrent(situation);
        }
        OutputUserCar.printFinalResultComment();
    }
}
