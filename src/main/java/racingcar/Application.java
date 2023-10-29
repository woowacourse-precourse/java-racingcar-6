package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCarController racingCarController = new RacingCarController(inputView);
        racingCarController.startRacingCarGame();
    }
}
