package racingcar;

public class Application {
    public static void main(String[] args) {
        IO io = new IO();
        Game game = new Game(io);
        game.start();
    }
}
