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

    @Override
    public String toString() {
        List<String> names = getNames();
        return String.join(", ", names);
    }

    private List<String> getNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getLead(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}