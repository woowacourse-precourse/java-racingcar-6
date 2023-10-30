package racingcar;

import racingcar.input.InputManager;
import racingcar.game.Roster;

public class Application {
    public static void main(String[] args) {
        String carNames = InputManager.readCarNames();
        Roster roster = new Roster(carNames);
        int numberOfAttempts = InputManager.readNumberOfAttempts();
        for (int i = 0; i < numberOfAttempts; i++) {
            roster.moveAllCarsForward();
        }
        roster.updateLongestCarRoute();
        roster.determineWinningCars();
    }
}