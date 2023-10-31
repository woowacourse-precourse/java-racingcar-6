package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicatedCar(cars);
        this.cars = cars;
    }

    private void validateDuplicatedCar(List<Car> cars) {
        long distinctCount = cars.stream()
                .distinct()
                .count();
        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
