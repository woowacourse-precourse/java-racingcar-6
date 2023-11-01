package racingcar;

import racingcar.controller.RacingCarController;

public class Application {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        RacingCarController.start();
    }
}
