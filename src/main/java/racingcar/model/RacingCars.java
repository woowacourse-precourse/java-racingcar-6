package racingcar.model;

import racingcar.Const;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public void setCar(String carName) {
        cars.add(new Car(carName));
    }

    public void runCars() {
        cars.forEach(Car::move);
    }

    public String extractStatusString() {
        return cars.stream().map(Car::toString).collect(Collectors.joining(Const.EXTRACT_CAR_STATUS_DELIMITER));
    }

    public int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow().getPosition();
    }

    public List<Car> getWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
