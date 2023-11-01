package racingcar;

import racingcar.config.GameConfig;
import racingcar.controller.RacingCarGame;
import racingcar.domain.RandomMovingStrategy;

public class Application {
    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig(new RandomMovingStrategy());

        RacingCarGame racingCarGame = new RacingCarGame(gameConfig);
        racingCarGame.play();
    }
}
