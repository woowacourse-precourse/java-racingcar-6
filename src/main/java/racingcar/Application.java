package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.CarFactoryService;
import racingcar.service.GameResultPublishService;
import racingcar.service.RacingGameService;
import racingcar.service.RoundExecutionService;
import racingcar.service.WinnerSelectionService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RacingGameService racingGameService = new RacingGameService(
                new GameResultPublishService(),
                new CarFactoryService(),
                new RoundExecutionService(),
                new WinnerSelectionService());

        RacingGameController racingGameController = new RacingGameController(
                new InputView(),
                new OutputView(),
                racingGameService);

        racingGameController.runRacingGame();
    }
}
