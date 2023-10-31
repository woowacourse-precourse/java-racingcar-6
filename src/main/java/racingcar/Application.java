package racingcar;

public class Application {
    public static final racingcarGame racingCarGame = new racingcarGame();

    public static void main(String[] args) {
        racingCarGame.startGame();
        racingCarGame.printGameResult();
    }


}
