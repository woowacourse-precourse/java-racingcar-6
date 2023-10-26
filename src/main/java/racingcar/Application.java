package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RacingController racingController = new RacingController(
                new InputView(),
                new OutputView(),
                new RacingModel());

        racingController.startRacing();

    }
}
