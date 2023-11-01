package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager();
        RacingGame racingGame = new RacingGame(gameManager.inputCarsName(),gameManager.inputNumber());
        racingGame.playRacingGame();

    }
}
