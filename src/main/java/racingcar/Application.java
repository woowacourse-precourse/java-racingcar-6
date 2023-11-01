package racingcar;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarsName();
        int attempts = InputView.inputAttemptCount();

        RacingGame racingGame = new RacingGame(Arrays.asList(carNames), attempts);
        racingGame.start();
    }
}
