package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Referee(List<Car> cars) {
        this.cars = ;
    }

    public List<Car> findWinners() {
        Car maxPositionCar = findFarthestPositionCar();
        List<Car> winners = findSamePositionCar(maxPositionCar);

        return winners;
    }

    public Car findFarthestPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("자동차 리스트가 비어있습니다."));
    }

    public List<Car> findSamePositionCar(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.compareTo(maxPositionCar) == 0)
                .collect(Collectors.toList());
    }
}
