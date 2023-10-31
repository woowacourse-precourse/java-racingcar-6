package racingcar;

import java.util.List;
import java.util.ArrayList;

public class RaceGame {
    public static void main(String[] args) {
        try {
            playRacingGame();
        } catch (IllegalArgumentException e) {
            handleException(e);
        }
    }

    private static void playRacingGame() {
        String[] carNames = InputManager.getCarNames();
        int numberOfAttempts = InputManager.getNumberOfAttempts();
        List<Car> cars = initializeCars(carNames);

        for (int round = 1; round <= numberOfAttempts; round++) {
            Race.startRace(cars, 1);
            OutputManager.printRoundResult(round, cars);
        }

        List<Car> winners = getWinners(cars);
        OutputManager.printWinners(winners);
    }

    private static List<Car> initializeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void handleException(IllegalArgumentException e) {
        System.out.println("오류: " + e.getMessage());
    }

    public static List<Car> getWinners(List<Car> cars) {
        int maxPosition = -1;
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            int carPosition = car.getPosition();
            if (carPosition > maxPosition) {
                maxPosition = carPosition;
                winners.clear();
                winners.add(car);
            } else if (carPosition == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }
}
