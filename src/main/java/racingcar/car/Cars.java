package racingcar.car;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void tryOnce() {
        cars.forEach(Car::tryOnce);
    }

    public List<String> Results() {
        return cars.stream()
                .map(car -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(car.getName());
                    sb.append(" : ");
                    sb.append("-".repeat(car.getMoveCount()));
                    return sb.toString();
                })
                .collect(Collectors.toList());
    }

    public List<String> winners() {
        int maximumMoveCount = cars.stream()
                .max(Comparator.comparing(Car::getMoveCount))
                .orElseThrow(NoSuchElementException::new)
                .getMoveCount();

        return cars.stream()
                .filter(car -> car.getMoveCount() == maximumMoveCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
