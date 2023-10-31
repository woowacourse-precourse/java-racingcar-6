package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validation_Duplicate(cars);
        this.cars = cars;
    }

    private void validation_Duplicate(List<Car> cars) {
        List<String> carNames = cars.stream()
                .map(Car::getName)
                .toList();

        Set<String> carNameWithoutDuplication = new HashSet<>(carNames);

        if (carNameWithoutDuplication.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야합니다.");
        }
    }


    public Car get(int i) {
        return cars.get(i);
    }

    public String toString() {
        return Arrays.toString(this.cars.toArray());
    }

    public int size() {
        return cars.size();
    }
}
