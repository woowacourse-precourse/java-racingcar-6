package racingcar;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        try {
            String[] carNames = InputManager.getCarNames();
            int numberOfAttempts = InputManager.getNumberOfAttempts();

            List<Car> cars = new ArrayList<>();
            for (String name : carNames) {
                cars.add(new Car(name));
            }

            for (int round = 1; round <= numberOfAttempts; round++) {
                Race.startRace(cars, 1);
                OutputManager.printRoundResult(round, cars);
            }

            List<Car> winners = RaceGame.getWinners(cars);
            OutputManager.printWinners(winners);

        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
