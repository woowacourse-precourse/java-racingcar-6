package racingcar;


import racingcar.controller.CarGameController;

public class Application {
    public static void main(String[] args) {
        CarGameController carGameController = new CarGameController();
        carGameController.init();
    }
}
