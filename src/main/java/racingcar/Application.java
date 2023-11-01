package racingcar;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(), new OutputView(), new Player(), new GameService());
        gameController.play();
    }
}
