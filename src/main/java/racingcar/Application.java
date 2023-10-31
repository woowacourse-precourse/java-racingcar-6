package racingcar;

import racingcar.domain.CarRacingManager;

public class Application {
    public static void main(String[] args) {
        CarRacingManager carRacingManager = new CarRacingManager();
        carRacingManager.execute();
    }
}
