package racingcar;

import racingcar.game.RacingGame;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.getInstance();
        racingGame.startGame();
    }
}
