package racingcar;

import racingcar.controller.RacingGame;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = AppConfig.racingGame();
        racingGame.playRacingGame();
    }
}
