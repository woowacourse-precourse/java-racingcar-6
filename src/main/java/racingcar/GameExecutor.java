package racingcar;

public class GameExecutor {
    private Game game;
    private OutputInterface out;

    public GameExecutor(Game game,  OutputInterface out) {
        this.game= game;
        this.out = out;
    }

    public void run() {
        while(!game.isFinished()){
            game.runStage();
            out.printStage(game);
        }
        out.printWinners(game.getWinners());
    }
}
