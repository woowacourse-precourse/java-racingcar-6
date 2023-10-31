package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Referee {

    public List<Car> getFurthestCar(List<Car> cars) {
        return cars.stream()
                .peek(Car::getDistance)
                .collect(Collectors.toList());
    }
}
