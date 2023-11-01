package racingcar;
import racingcar.controller.GameManager;

public class Application {
    public static GameManager gameManager;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameManager = new GameManager();
        gameManager.playGame();
    }
}
