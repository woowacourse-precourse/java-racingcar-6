package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = Configuration.racingCarController();
        racingCarController.inputCarNames();
        racingCarController.inputTryNumber();
        racingCarController.racingGameRun();
        racingCarController.outputWinner();
    }
}
