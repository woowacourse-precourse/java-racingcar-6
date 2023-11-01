package racingcar.controller;

import racingcar.service.RacingCar;

public class RacingCarController {
    public static void run() {
        RacingCar racingCar = new RacingCar();
        racingCar.doMoveForward();
        racingCar.printWinners();
    }
}
