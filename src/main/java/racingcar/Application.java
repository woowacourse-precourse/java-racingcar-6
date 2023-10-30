package racingcar;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        Round round = new Round();
        GameController gameController = new GameController(game, round);
        gameController.execute();
    }
}
