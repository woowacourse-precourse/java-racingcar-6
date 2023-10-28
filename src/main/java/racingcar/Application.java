package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.CarModel;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();

        racingController.carNamesProcess();
        racingController.repeatNumberProcess();
        racingController.racingStart();
        racingController.resultWinner();
    }
}
