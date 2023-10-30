package racingcar;

import racingcar.Controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        final RacingCarController car = new RacingCarController();
        car.run();
    }
}
