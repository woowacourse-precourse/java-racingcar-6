package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATED_NAME_ERROR_MESSAGE = "중복된 이름 삽입 불가";
    private static final String CARS_RANGE_ERROR_MESSAGE = "자동차의 개수는 1개 이상이어야 함";

    private List<Car> cars;

    private Cars() {
        this.cars = new ArrayList<>();
    }

    public void updateAllDistance() {
        cars.forEach(Car::updateDistance);
    }

    public static Cars createNewCars() {
        return new Cars();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void insert(Car car) {
        if (!validateIfDuplicatedNameExists(car.getName())) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR_MESSAGE);
        }
        cars.add(car);
    }

    private boolean validateIfDuplicatedNameExists(String newName) {
        return cars.stream().noneMatch(car -> car.getName().equals(newName));
    }

    private Car getMaxDistanceCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(CARS_RANGE_ERROR_MESSAGE));
    }

    public List<String> findWinners() {
        return cars.stream()
                .filter(getMaxDistanceCar()::isSameDistance)
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }


}
