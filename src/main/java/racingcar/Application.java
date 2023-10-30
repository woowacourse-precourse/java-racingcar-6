package racingcar;

import racingcar.gameLogic.RacingCar;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();

        racingCar.init();
        racingCar.run();
    }
}
