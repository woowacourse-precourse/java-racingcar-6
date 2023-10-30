package racingcar;

public class RacingCarGame {
    private static RacingCarGame racingCarGame;

    private RacingCarGame() {
    }

    public static RacingCarGame getInstance() {
        if (racingCarGame == null) {
            racingCarGame = new RacingCarGame();
        }
        return racingCarGame;
    }

    public void run() {
    }

}