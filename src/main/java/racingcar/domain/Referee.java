package racingcar.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    private Car findMaxDistanceCar(Collection<Car> carList) {
        return carList.stream()
                .max(Car::compareTo)
                .orElse(null);
    }
}
