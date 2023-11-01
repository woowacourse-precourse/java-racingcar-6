package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.CampRandomGenerator;
import racingcar.service.MoveStrategy;
import racingcar.service.RandomMoveStrategy;
import racingcar.service.WinnerService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TriesCountValidator;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = initializeGameController();
        racingGameController.startRacingGame();
    }

    private static RacingGameController initializeGameController() {
        MoveStrategy moveStrategy = new RandomMoveStrategy(new CampRandomGenerator());
        CarNameValidator carNameValidator = new CarNameValidator();
        TriesCountValidator triesCountValidator = new TriesCountValidator();
        WinnerService winnerService = new WinnerService();

        return new RacingGameController(moveStrategy, carNameValidator, triesCountValidator, winnerService);
    }
}
