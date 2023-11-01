package racingcar;

import racingcar.domain.game.GameConfig;
import racingcar.domain.game.RacingCarGame;

public class Application {
    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig();
        RacingCarGame game = new RacingCarGame(gameConfig);
        game.run();
    }
}
