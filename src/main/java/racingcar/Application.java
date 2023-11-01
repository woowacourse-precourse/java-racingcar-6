package racingcar;

public class Application {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager(new Input(), new Output());
        gameManager.startGame();
    }
}
