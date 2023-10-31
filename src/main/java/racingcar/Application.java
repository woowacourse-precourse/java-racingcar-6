package racingcar;

public class Application {
    private static RacingCarGame racingCarGame;
    public static void main(String[] args) {
        racingCarGame = new RacingCarGame();
        racingCarGame.play();
    }
}
