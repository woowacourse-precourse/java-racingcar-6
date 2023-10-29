package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

import static racingcar.view.OutputView.moveDistanceMessage;

public class GameProcess {
    public void processGame(RacingCarList racingCars) {
        for (int carIndex = 0; carIndex < racingCars.size(); carIndex++) {
            int randomNumber = new GameUtils().makeRandomNumber();
            RacingCar currentCar = racingCars.getCar(carIndex);
            currentCar.moveForward(randomNumber);
        }
        printGameAttemptResult(racingCars);
    }

    public void printGameAttemptResult(RacingCarList racingCars) {
        for (int element = 0; element < racingCars.size(); element++) {
            RacingCar racingCar = racingCars.getCar(element);
            moveDistanceMessage(racingCar);
        }
        System.out.println();
    }
}
