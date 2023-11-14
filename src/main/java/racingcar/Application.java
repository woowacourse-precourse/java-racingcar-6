package racingcar;

import racingcar.controller.Game;
import racingcar.model.ForwardStrategy;
import racingcar.model.RandomForwardStrategy;

public class Application {
    public static void main(String[] args) {
        ForwardStrategy forwardStrategy = new RandomForwardStrategy();
        Game game = new Game(forwardStrategy);
        game.start();
    }
}
