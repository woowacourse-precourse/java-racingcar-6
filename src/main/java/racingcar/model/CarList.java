package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private final List<Car> carList;

    public CarList(String[] carNames) {
        this.carList = generateCars(carNames);
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

    public List<Car> generateCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
