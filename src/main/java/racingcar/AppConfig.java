package racingcar;

import racingcar.controller.CarsController;
import racingcar.controller.CarsCreator;
import racingcar.controller.RacingGame;
import racingcar.controller.Repeat;

public class AppConfig {
    public static RacingGame racingGame() {
        return new RacingGame(carListCreator(), repeat());
    }

    private static CarsCreator carListCreator() {
        return new CarsController();
    }
    private static Repeat repeat() {
        return new Repeat();
    }

}
