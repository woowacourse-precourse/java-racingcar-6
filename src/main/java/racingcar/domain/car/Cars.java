package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.mapper.CarMapper;

public class Cars {
    private static final int MINIMUM_CARS_SIZE = 2;
    private static final int MAXIMUM_CARS_SIZE = 5;
    private List<Car> cars;

    public Cars(String names) {
        List<Car> targetCars = CarMapper.convertToCarList(names);
        validateCarSize(targetCars);
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

    private void validateCarSize(List<Car> cars) {
        if (isOverValidCarSize(cars.size())) {
            throw new IllegalArgumentException("자동차의 갯수는 2~5개 사이여야 합니다.");
        }
    }

    private boolean isOverValidCarSize(int size) {
        return size < MINIMUM_CARS_SIZE || MAXIMUM_CARS_SIZE < size;
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
