package racingcar.controller;

import java.util.Map;
import racingcar.model.Car;
import racingcar.view.OutputUserCar;
import racingcar.view.PrintComment;

public class RacingCarController {
    private Car car;

    public RacingCarController() {
        car = new Car();
    }

    public void game() {
        PrintComment.printInitComment();
        car.setCars();
        PrintComment.printTrialComment();
        int trialNumber = car.setTrial();
        while (trialNumber-- > 0) {
            Map<String, Integer> situation = car.goFront();
            OutputUserCar.printResultComment();
            OutputUserCar.racingCurrent(situation);
        }
        OutputUserCar.printFinalResultComment();
    }
}
