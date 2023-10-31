package game;

public class GameExecutor {
    private Game game;

    public GameExecutor(Game game) {
        this.game = game;
    }

    public void run() {
        while (!game.isFinished()) {
            game.runStage();
            game.printStage();
        }
        game.printResult();
    }
}
