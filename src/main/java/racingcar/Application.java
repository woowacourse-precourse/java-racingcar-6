package racingcar;

import racingcar.app.ApplicationConfig;
import racingcar.domain.interfaces.Game;

public class Application {
    public static void main(String[] args) {
        Game racingGame = ApplicationConfig.getApplicationGame();
        racingGame.start();
    }
}
