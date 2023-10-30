package racingcar;

import racingcar.controller.RacingGame;
import racingcar.service.Referee;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new Referee());
        racingGame.run();
    }
}
