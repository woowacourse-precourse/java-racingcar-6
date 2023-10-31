package racingcar;

import racingcar.controller.RacingGameConsole;
import racingcar.domain.strategy.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        RacingGameConsole racingGameConsole = new RacingGameConsole(new RandomMoveStrategy());
        racingGameConsole.run();
    }
}
