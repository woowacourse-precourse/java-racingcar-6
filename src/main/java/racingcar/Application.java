package racingcar;

public class Application {
    public static void main(String[] args) {
        new Game(new GameService()).doGame();
    }
}
