package racingcar;

import racingcar.domain.system.game.Game;
import racingcar.initializer.RacingGameInitializer;

public class Application {

    public static void main(String[] args) {
        Game game = new RacingGameInitializer().getGame();
        game.start();
    }
}
