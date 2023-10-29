package racingcar.model;

import java.util.List;

public class RaceManager {
    public static int validateNumberOfMove(String numberOfMove) {
        int number = toNumber(numberOfMove);
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static List<String> decideWinner(List<Car> cars) {
        return cars.stream()
                .filter((car) -> isWinner(car, calculateFarthestLocation(cars)))
                .map(Car::getName)
                .toList();
    }

    private static int calculateFarthestLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private static boolean isWinner(Car car, int farthestLocation) {
        if (car.getLocation() == farthestLocation) {
            return true;
        }
        return false;
    }

    private static int toNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
