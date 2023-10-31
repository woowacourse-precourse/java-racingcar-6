package racingcar;

import game.GameStatus;
import game.RacingGame;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        while (game.status != GameStatus.EXIT) {
            game.run();
        }
    }
}