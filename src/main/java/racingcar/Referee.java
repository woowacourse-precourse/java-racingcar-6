package racingcar;

import java.util.List;

public class Referee {
    public List<Car> getWinner(List<Car> cars) {
        int maxPoint = getMaxPoint(cars);
        return cars.stream()
                .filter(car -> car.getPoint() == maxPoint)
                .toList();
    }

    private int getMaxPoint(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPoint)
                .max()
                .orElse(0);
    }
}
