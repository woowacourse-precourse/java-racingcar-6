package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.userInput();
        game.gameSystem();
        game.printWinners();
    }
}
