package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.utils.InputReader;

public class Application {
    public static void main(String[] args) {
        RacingService racingService = new RacingService();
        InputReader inputReader = new InputReader();
        RacingController racingController = new RacingController(racingService, inputReader);
        racingController.start();
    }
}
