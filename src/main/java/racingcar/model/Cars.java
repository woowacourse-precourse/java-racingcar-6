package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getCarsWithHighestDistance() {
        List<Car> carsWithHighestDistance = new ArrayList<>();

        if (cars.isEmpty()) {
            return carsWithHighestDistance;
        }

        // 가장 높은 distance 값 찾기
        Integer highestDistance = cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElse(0);

        // 가장 높은 distance를 가진 모든 Car 객체 찾기
        cars.forEach(car -> {
            if (car.getDistance().equals(highestDistance)) {
                carsWithHighestDistance.add(car);
            }
        });

        return carsWithHighestDistance;
    }
}
