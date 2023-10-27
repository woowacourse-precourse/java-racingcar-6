package racingcar.app;

import racingcar.domain.RacingCarFactory;
import racingcar.domain.RacingGame;
import racingcar.domain.interfaces.Game;

public class ApplicationConfig {

    public static Game getApplicationGame() {
        return new RacingGame(new RacingCarFactory());
    }

}
