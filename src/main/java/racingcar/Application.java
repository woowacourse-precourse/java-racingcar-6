package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        MoveFactory moveFactory = new MoveFactory(numberGenerator);
        GameController gameController = new GameController(moveFactory);

        gameController.start();
    }
}
