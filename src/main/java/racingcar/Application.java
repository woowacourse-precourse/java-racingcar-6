package racingcar;

import racingcar.manager.CarRacingManager;

public class Application {
    public static void main(String[] args) {
        CarRacingManager carRacingManager = new CarRacingManager();
        carRacingManager.execute();
    }
}
