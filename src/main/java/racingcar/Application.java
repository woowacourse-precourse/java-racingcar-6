package racingcar;

import racingcar.input.InputManager;
import racingcar.game.Racing;

public class Application {
    public static void main(String[] args) {
        String carNames = InputManager.readCarNames();
        Racing racing = new Racing(carNames);
        int numberOfAttempts = InputManager.readNumberOfAttempts();
        for (int i = 0; i < numberOfAttempts; i++) {
            racing.moveAllCarsForward();
        }
        racing.updateLongestCarRoute();
        racing.determineWinningCars();
    }
}