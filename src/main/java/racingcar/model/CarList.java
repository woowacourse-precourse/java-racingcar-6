package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private final List<Car> carList = new ArrayList<>();

    public List<Car> carList() {
        return Collections.unmodifiableList(carList);
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

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
