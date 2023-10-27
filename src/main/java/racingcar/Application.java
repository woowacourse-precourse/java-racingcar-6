package racingcar;

import racingcar.controller.GameController;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        DependencyConfig config = new DependencyConfig();
        GameController gameController = config.gameController();
        gameController.playGame();
    }
}
