package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        this.cars.addAll(createCarsFromNames(carNames));
    }

    public Map<Name, Distance> getCurrentStatus() {
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getDistance));
    }

    public void moveAllCars(Navigator navigator) {
        cars.forEach(car -> car.move(navigator));
    }

    public int getSize() {
        return cars.size();
    }

    private List<Car> createCarsFromNames(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .distinct()
                .map(name -> new Car(new Name(name)))
                .toList();

        if (carList.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
        return carList;
    }
}
