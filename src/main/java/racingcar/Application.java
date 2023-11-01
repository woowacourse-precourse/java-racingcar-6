package racingcar;

public class Application {
    public static void main(String[] args) {
        try {
            RacingGame game = new RacingGame();
            GameConsole.play(game);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
