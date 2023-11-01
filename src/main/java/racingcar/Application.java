package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.CarFactoryService;
import racingcar.service.GameResultPublishService;
import racingcar.service.RacingGameService;
import racingcar.service.RoundExecutionService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RacingGameController racingGameController = new RacingGameController(
                new InputView(),
                new OutputView(),
                new RacingGameService(new GameResultPublishService(), new CarFactoryService(),
                        new RoundExecutionService()));
        racingGameController.runRacingGame();
    }
}
