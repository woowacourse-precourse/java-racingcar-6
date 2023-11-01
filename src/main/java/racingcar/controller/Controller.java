package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingGame;

import java.util.*;

public class Controller {
    static List<Car> carList = new ArrayList<Car>();
    public static void gameStart(){
        String[] tempCarList = RacingGame.inputCarName();

        for(String carName : tempCarList){
            Car tempCar = new Car(carName.trim());
            carList.add(tempCar);
        }
        int racingRound = RacingGame.inputRacingRound();

        RacingGame.outputService(carList, racingRound);

    }
}
