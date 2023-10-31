package racingcar;

import racingcar.controller.CarController;

public class Application {
    public static void main(String[] args) {
        CarController racingController = new CarController();
        racingController.play();
    }
}
