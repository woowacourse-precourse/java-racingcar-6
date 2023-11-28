package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new InputViewImpl(), new OutputViewImpl());
        racingCarController.run();
    }
}
