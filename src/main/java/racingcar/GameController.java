package racingcar;

public class GameController {
    private final Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void execute() {
        game.initialize();
        play();
    }

    private void play() {
        int roundCount = 0;
        PromptHandler.promptOutput(GameMessage.EXECUTION_RESULT.getMessage());
        while (game.isProcess(++roundCount)) {
            game.play();
            PromptHandler.promptOutput(game.getTotalExecuteResult());
        }
        PromptHandler.promptOutputWinner(game.getWinner());
    }
}
