package racingcar;

import racingcar.config.RacingCarGameFactory;
import racingcar.domain.RacingCarGame;

public class Application {
    public static void main(String[] args) {
        final RacingCarGame racingCarGame = RacingCarGameFactory.createSingletonRacingCarGame();
        racingCarGame.start();
    }

}
