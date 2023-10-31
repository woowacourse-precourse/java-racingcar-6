package racingcar;

import game.RacingGame;

public class Application {
    public static void main(String[] args) {
        RacingGame game = RacingGame.getInstance();
        game.run();
        game.close();
    }
}
