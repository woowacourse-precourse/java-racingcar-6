package racingcar;

import racingcar.controller.CarController;

public class Application {
    public static void main(String[] args) {
        CarController racingCarGame = new CarController();
        racingCarGame.startGame();
    }
}
