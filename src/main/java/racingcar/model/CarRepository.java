package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private final List<Car> cars;

    public CarRepository(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getMaxCars() {
        int max = getMaxForwardCounts();

        return cars.stream()
                .filter(car -> car.getForwardCount() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxForwardCounts() {
        return cars.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(0);
    }

}
