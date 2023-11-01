package racingcar.controller;

import racingcar.model.CarRacing;
import racingcar.view.Enter;

public class CarRacingGameStart {

    public void gameStart() {
        Enter enter = new Enter();
        String[] carsName =  enter.enterCarsName(); // String[] 반환
        int numberTry =  enter.enterNumberTry();// 시도횟수 반환 (int)

        CarRacing carRacing = new CarRacing();
        carRacing.racingController(carsName, numberTry);
    }
}
