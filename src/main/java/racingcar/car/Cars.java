package racingcar.car;

import java.util.List;
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

    public List<String> toResults() {
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
}
