package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame(
                new RacingGameConsoleView(),
                new RandomActionNumberGenerator());
        game.play();
    }
}
