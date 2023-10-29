package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.CampRandomGenerator;
import racingcar.service.MoveStrategy;
import racingcar.service.RandomMoveStrategy;
import racingcar.service.WinnerDeterminationService;
import racingcar.validator.CarNameInputValidator;
import racingcar.validator.TriesCountInputValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MoveStrategy moveStrategy = new RandomMoveStrategy(new CampRandomGenerator());
        CarNameInputValidator carNameInputValidator = new CarNameInputValidator();
        TriesCountInputValidator triesCountInputValidator = new TriesCountInputValidator();
        WinnerDeterminationService winnerDeterminationService = new WinnerDeterminationService();

        RacingGameController racingGameController = new RacingGameController(moveStrategy,carNameInputValidator,triesCountInputValidator,winnerDeterminationService);

        racingGameController.racingGame();
    }
}
