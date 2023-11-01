package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<Car> cars) {
        validDuplicateNames(cars);
        return new Cars(cars);
    }

    private static void validDuplicateNames(List<Car> cars) {
        List<String> names = cars.stream().map(Car::getName).toList();
        long distinctCount = names.stream().distinct().count();
        if (distinctCount < names.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        int maxLocation = cars.stream().mapToInt(Car::getCurrentLocation).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getCurrentLocation() == maxLocation)
                .collect(Collectors.toList());
    }
}
