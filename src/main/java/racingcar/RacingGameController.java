package racingcar;

public class RacingGameController {
    private final RacingGame racingGame = new RacingGame();

    public void startGame() {
        racingGame.initializeGame();
        racingGame.playGame();
        racingGame.announceWinners();
    }
}
