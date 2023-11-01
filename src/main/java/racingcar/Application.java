package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.CarFactoryService;
import racingcar.service.RacingGameService;
import racingcar.service.RefereeService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RacingGameController racingGameController = new RacingGameController(
                new InputView(),
                new OutputView(),
                new RacingGameService(new RefereeService(), new CarFactoryService()));

        racingGameController.runRacingGame();
    }
}
