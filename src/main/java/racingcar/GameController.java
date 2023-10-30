package racingcar;

public class GameController {
    private Game game;
    private Round round;
    public GameController(Game game, Round round) {
        this.game = game;
        this.round = round;
    }

    public void execute() {
        game.initialize();
        round.initialize();
        play();
    }

    private void play() {
        int roundCount = 0;
        while (round.isProcess(++roundCount)) {
            round.play();
        }
    }

}
