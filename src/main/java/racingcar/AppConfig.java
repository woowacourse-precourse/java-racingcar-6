package racingcar;

import racingcar.controller.CarsController;
import racingcar.controller.CarsCreator;
import racingcar.controller.RacingGame;
import racingcar.controller.RepeatController;
import racingcar.controller.RepeatNumCreator;

public class AppConfig {
    public static RacingGame racingGame() {
        return new RacingGame(carsCreator(), repeatNumCreator());
    }

    private static CarsCreator carsCreator() {
        return new CarsController();
    }
    private static RepeatNumCreator repeatNumCreator() {
        return new RepeatController();
    }

}
