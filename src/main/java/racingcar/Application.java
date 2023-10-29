package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.strategy.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new RandomMoveStrategy());
        racingGame.start();
    }
}
