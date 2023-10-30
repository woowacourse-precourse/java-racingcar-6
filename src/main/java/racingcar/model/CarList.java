package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public int getMaxPosition() {
        List<Integer> positions = carList.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
        return Collections.max(positions);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
