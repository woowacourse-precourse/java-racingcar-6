package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 자동차 경주 게임 구현
        GameController controller = GameController.getInstance();
        controller.startGame();
    }
}
