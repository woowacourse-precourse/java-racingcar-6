package racingcar;

public class Application {
    public static void main(String[] args) {
        GameUI gameUI = new GameUI();
        RacingGame racingGame = new RacingGame(gameUI);
        racingGame.run();
    }
}
