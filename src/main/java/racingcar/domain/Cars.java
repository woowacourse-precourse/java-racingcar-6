package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> moveCars(int randomNumber) {
        return carList.stream()
                .map(car -> car.move(randomNumber))
                .collect(Collectors.toList());
    }

    public List<Car> getWinnerCars() {
        return carList.stream()
                .filter(car -> car.getLocationLength() == getMaxLocationLength())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getNamesOfCars(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxLocationLength() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getLocationLength))
                .map(Car::getLocationLength)
                .get();
    }
}
