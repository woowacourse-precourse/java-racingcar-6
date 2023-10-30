package racingcar;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        String carNames = gameManager.askCarNames();
        int tryCount = gameManager.askTryCount();

        Game game = new Game(carNames, tryCount);
        game.play();
        game.printFinalResult();
    }
}