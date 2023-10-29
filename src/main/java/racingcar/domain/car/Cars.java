package racingcar.domain.car;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.mapper.CarMapper;

public class Cars {
    private List<Car> cars;

    public Cars(String names) {
        List<Car> targetCars = CarMapper.convertToCars(names);
        validateDuplicateName(targetCars);
        this.cars = targetCars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Car findCarByIndex(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    private void validateDuplicateName(List<Car> cars) {
        if (isContainDuplicateName(cars)) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 존재합니다.");
        }
    }

    private boolean isContainDuplicateName(List<Car> cars) {
        List<Car> target = cars.stream()
                .map(Car::getName)
                .distinct()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
        return target.size() != cars.size();
    }
}
