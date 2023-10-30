package racingcar;

import racingcar.Service.RacingGame;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        racingGame.gameStart();
        racingGame.gamePlay();
        racingGame.gameEnd();
    }
}
