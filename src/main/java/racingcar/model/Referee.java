package racingcar.model;

import java.util.List;

public class Referee {
    public static List<Car> getWinner(List<Car> cars) {
        int maxPoint = getMaxPoint(cars);
        return cars.stream()
                .filter(car -> car.getPoint() == maxPoint)
                .toList();
    }

    private static int getMaxPoint(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPoint)
                .max()
                .orElse(0);
    }
}
