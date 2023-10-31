package racingcar;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = InputView.getCarNames();
        String[] carNames = carNamesInput.split(",");
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        racingGame.runGame();
    }
}
