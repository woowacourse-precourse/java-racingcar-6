package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.setup(
                new MoveForwardConditioner(0, 9),
                new InputArgumentsHandler()
        );
        racingCarGame.play();
    }
}
