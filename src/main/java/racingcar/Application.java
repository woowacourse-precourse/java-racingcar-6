package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.generator.CampRandomGenerator;
import racingcar.service.MoveService;
import racingcar.service.RandomMoveService;
import racingcar.service.WinnerService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TriesCountValidator;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = initializeGameController();
        racingGameController.startRacingGame();
    }

    private static RacingGameController initializeGameController() {
        MoveService moveService = new RandomMoveService(new CampRandomGenerator());
        CarNameValidator carNameValidator = new CarNameValidator();
        TriesCountValidator triesCountValidator = new TriesCountValidator();
        WinnerService winnerService = new WinnerService();

        return new RacingGameController(moveService, carNameValidator, triesCountValidator, winnerService);
    }
}
