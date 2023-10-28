package racingcar;

public class Application {
    public static void main(String[] args) {

        RacingGameConfig gameConfig = new RacingGameConfig();
        RacingGame racingGame = gameConfig.initRacingGame();
        racingGame.startGame();
    }
}
