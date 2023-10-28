package racingcar;

import racingcar.controller.CarRaceGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CarRaceGameController carRaceGameController = new CarRaceGameController();
        carRaceGameController.gameStart();
    }
}
