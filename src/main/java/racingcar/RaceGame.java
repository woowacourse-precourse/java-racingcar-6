package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
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

            List<Car> winners = getWinners(cars);
            OutputManager.printWinners(winners);

        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }

    private static List<Car> getWinners(List<Car> cars) {
        int maxPosition = -1;
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car);
            } else if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }
}
