package racingcar;

import racingcar.Controller.RacingCarController;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.run();
    }
}
