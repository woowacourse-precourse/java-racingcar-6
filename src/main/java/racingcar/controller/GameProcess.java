package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

import static racingcar.view.OutputView.*;

public class GameProcess {
    public void processGame(RacingCarList racingCars) {
        GameUtils util = new GameUtils();
        for (int carIndex = 0; carIndex < racingCars.size(); carIndex++) {
            int randomNumber = util.makeRandomNumber();
            RacingCar currentCar = racingCars.getCar(carIndex);
            currentCar.moveForward(randomNumber);
        }
        printGameAttemptResult(racingCars, racingCars.size());
    }

    public void printGameAttemptResult(RacingCarList racingCars, int length) {
        for (int element = 0; element < length; element++) {
            RacingCar racingCar = racingCars.getCar(element);
            moveDistanceMessage(racingCar);
        }
        newLine();
    }
}
