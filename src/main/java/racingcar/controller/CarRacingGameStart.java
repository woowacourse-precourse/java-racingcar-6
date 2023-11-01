package racingcar.controller;

import racingcar.model.CarAndDistance;
import racingcar.model.CarRacing;
import racingcar.view.CarRaceResult;
import racingcar.view.Enter;

public class CarRacingGameStart {

    public void gameStart() {
        // 입력
        Enter enter = new Enter();
        String[] carsName =  enter.enterCarsName();
        int numberTry =  enter.enterNumberTry();

        // 게임 시작
        CarRacing carRacing = new CarRacing();
        CarAndDistance carAndDistance = carRacing.racingController(carsName, numberTry);

        // 게임 결과
        CarRaceResult carRaceResult = new CarRaceResult();
        carRaceResult.carRacingWinner(carAndDistance);
    }
}
