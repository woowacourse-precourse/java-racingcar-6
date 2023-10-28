package racingcar;

import java.util.Arrays;
import racingcar.controller.RacingController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.racingReady();
    }
}
