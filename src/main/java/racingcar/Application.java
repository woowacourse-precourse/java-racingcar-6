package racingcar;

import racingcar.system.RacingCarApplication;
import racingcarv2.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        RacingCarApplication racingCarApplication = new RacingCarApplication();
//        racingCarApplication.run();
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.run();
    }
}
