package racingcar.evaluator;

import java.util.List;
import racingcar.domain.Car;

public class WinnerEvaluator {

    public List<String> getWinners(List<Car> cars) {
        int maxNumber = getMaxNumber(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxNumber)
                .map(Car::getName)
                .toList();
    }

    public int getMaxNumber(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
