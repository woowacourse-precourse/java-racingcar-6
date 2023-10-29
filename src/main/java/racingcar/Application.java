package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.Racing;

public class Application {
    public static void main(String[] args) {
        Racing racing = new Racing();
        RacingController racingController = new RacingController(racing);

        racingController.inputCarNames();
        racingController.inputReps();
        racingController.outputProgress();
        racingController.outputWinner();
    }
}
