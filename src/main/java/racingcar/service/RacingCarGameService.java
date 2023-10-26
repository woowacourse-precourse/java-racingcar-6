package racingcar.service;

import racingcar.constant.ActionConstant;
import racingcar.domain.Car;

public class RacingCarGameService {

    private static final int STANDARD_NUMBER = 4;

    public void moveOrStop(int diceNumber, Car car){
        if(diceNumber >= STANDARD_NUMBER){
            car.move(ActionConstant.MOVE);
            System.out.println(car.toString());
        }
    }
}
