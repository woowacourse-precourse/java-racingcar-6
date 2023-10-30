package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> cars) {
        this.carList = cars;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getCarsWithHighestDistance() {
        List<Car> carsWithHighestDistance = new ArrayList<>();

        if (carList.isEmpty()) {
            return carsWithHighestDistance;
        }

        // 가장 높은 distance 값 찾기
        Integer highestDistance = carList.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElse(0);

        // 가장 높은 distance를 가진 모든 Car 객체 찾기
        carList.forEach(car -> {
            if (car.getDistance().equals(highestDistance)) {
                carsWithHighestDistance.add(car);
            }
        });

        return carsWithHighestDistance;
    }
}
