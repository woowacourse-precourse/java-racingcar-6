package racingcar;

import racingcar.controller.CarGameController;

public class Application {

    private static final CarGameController carGameController = new CarGameController();

    public static void main(String[] args) {
        carGameController.start();
    }
}
