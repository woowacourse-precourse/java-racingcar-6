package racingcar;

import racingcar.controller.InputHandler;
import racingcar.controller.RaceController;
import racingcar.controller.CarRegisterController;
import racingcar.controller.ResultController;
import racingcar.model.RacingCars;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCars racingCars = new RacingCars();
        CarRegisterController registerController = new CarRegisterController(racingCars);
        RaceController raceController = new RaceController(racingCars);
        ResultController resultController = new ResultController(racingCars);

        registerController.registerCars();
        raceController.startRace();
        resultController.showWinners();
    }
}
