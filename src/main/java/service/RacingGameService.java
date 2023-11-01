package service;

import racingcar.model.Car;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class RacingGameService {

    public void determineMoveForward(Car car){
        if(generateRandomNumber() >= 4){
            car.moveCar();
        }
    }

    private int generateRandomNumber(){
        return pickNumberInRange(0,9);
    }
}
