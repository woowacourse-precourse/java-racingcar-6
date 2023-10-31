package racingcar;

import racingcar.play.PlayRacingGame;

public class Application {
    public static void main(String[] args) {
        PlayRacingGame playRacingGame = new PlayRacingGame();
        playRacingGame.input();
        playRacingGame.play();
        playRacingGame.printGameResult();
    }
}
