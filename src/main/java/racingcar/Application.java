package racingcar;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        GameHandler gameHandler = new GameHandler(game);

        gameHandler.handle();
    }
}
