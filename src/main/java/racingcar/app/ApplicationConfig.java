package racingcar.app;

import racingcar.domain.RacingCarFactory;
import racingcar.domain.RacingGame;
import racingcar.domain.interfaces.CarFactory;
import racingcar.domain.interfaces.Game;

public class ApplicationConfig {

    public static Game getApplicationGame() {
        return new RacingGame(getGameCarFactory());
    }

    public static CarFactory getGameCarFactory() {
        return new RacingCarFactory();
    }

}
