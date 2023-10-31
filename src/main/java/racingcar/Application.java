package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.input.InputViewImpl;
import racingcar.view.input.ValidateImpl;
import racingcar.view.output.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new InputViewImpl(new ValidateImpl()), new OutputViewImpl());
        racingController.run();
    }
}
