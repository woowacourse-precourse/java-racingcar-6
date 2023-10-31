package racingcar;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager(new InputManager(), new OutputManager());
        gameManager.run();
    }
}
