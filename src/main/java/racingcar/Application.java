package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.utils.RandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingGameController game = new RacingGameController(randomNumberGenerator);
        game.run();
    }
}
