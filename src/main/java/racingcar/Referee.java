package racingcar;

import java.util.List;

public class Referee {

    public List<Car> getWinners(List<Car> cars) {
        int maxMileage = getMaxMileage(cars);
        return cars.stream()
                .filter(car -> car.getMileageAsInt() == maxMileage)
                .toList();
    }

    private int getMaxMileage(List<Car> cars) {
        int maxMileage = 0;
        for (Car car : cars) {
            maxMileage = Math.max(maxMileage, car.getMileageAsInt());
        }
        return maxMileage;
    }
}
