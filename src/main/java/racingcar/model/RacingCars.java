package racingcar.model;

import racingcar.Const;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    List<Car> cars = new ArrayList<>();

    public void setCar(String carName) {
        cars.add(new Car(carName));
    }

    public void runCars() {
        cars.forEach(Car::move);
    }

    public String extractStatusString() {
        return cars.stream().map(Car::toString).collect(Collectors.joining(Const.EXTRACT_CAR_STATUS_DELIMITER));
    }
}
