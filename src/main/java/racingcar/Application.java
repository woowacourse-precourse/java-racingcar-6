package racingcar;

public class Application {
    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        RacingCarGame game = new RacingCarGame(prompt);
        game.start();
    }
}
