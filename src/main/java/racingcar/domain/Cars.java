package racingcar.domain;

import racingcar.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void makeCars(List<String> carNames) {
        cars.addAll(carNames.stream()
                .map(name -> new Car(name, 0))
                .toList());
    }

    public void moveCars() {
        cars.forEach(car -> car.moveCar(Utils.makeRandomNumber()));
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(car -> new Car(car.getName(), car.getDistance()))
                .toList();
    }

    public List<String> findWinner() {
        Car farthestCar = findFarthestCar();
        return findSameDistanceCar(farthestCar);
    }

    private Car findFarthestCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비어있습니다."));
    }

    private List<String> findSameDistanceCar(Car maxPositionCar) {
        return cars.stream()
                .filter(maxPositionCar::isSameDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
