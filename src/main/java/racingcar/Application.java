package racingcar;

import racingcar.controller.CarRaceGameController;
import racingcar.service.FacadeService;

public class Application {
    public static void main(String[] args) {
        CarRaceGameController carRaceGameController = new CarRaceGameController();

        carRaceGameController.play();

        // TODO: 프로그램 구현
    }
}

