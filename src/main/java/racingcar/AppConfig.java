package racingcar;

import racingcar.controller.CarListController;
import racingcar.controller.CarNamesController;
import racingcar.controller.RacingGame;

public class AppConfig {
    public static RacingGame racingGame() {
        return new RacingGame(carListController(), carNamesController());
    }

    private static CarListController carListController() {
        return new CarListController();
    }
    private static CarNamesController carNamesController() {
        return new CarNamesController();
    }
}
