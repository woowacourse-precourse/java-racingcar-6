package racingcar;

import racingcar.game.RacingGameManager;

public class Application {
    public static void main(String[] args) {
        RacingGameManager racingGameManager = new RacingGameManager();
        racingGameManager.gameStart();
    }
}
