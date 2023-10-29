package racingcar.controller;

public class Racing {
    private final Game game;
    private final Result result;

    public Racing(Game game, Result result) {
        this.game = game;
        this.result = result;
    }

    public void start() {
        executeRacingGame();
    }

    private void executeRacingGame() {
        game.play();
        result.announce();
    }
}
