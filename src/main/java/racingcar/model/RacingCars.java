package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Util;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<String> carNames) {
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public List<Car> play() {
        advanceCar();
        return getCarStatuses();
    }

    public List<Car> getWinners() {
        int maxPosition = Util.getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private List<Car> getCarStatuses() {
        return new ArrayList<>(cars);
    }

    private void advanceCar() {
        cars.forEach(Car::validRacingCars);
    }
}
