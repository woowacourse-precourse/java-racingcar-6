package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final List<Car> winners;

    public Winner(Cars cars) {
        int lead = getLead(cars.getCars());
        winners = cars.getCars()
                .stream()
                .filter(car -> car.getPosition() == lead)
                .collect(Collectors.toList());
    }

    public int getLead(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Position.DEFAULT_POSITION);
    }

    public List<Car> getWinners() {
        return winners;
    }
}