package racingcar;

import racingcar.config.CarRacingManager;

public class Application {
    public static void main(String[] args) {
        CarRacingManager carRacingManager = new CarRacingManager();
        carRacingManager.execute();
    }
}
