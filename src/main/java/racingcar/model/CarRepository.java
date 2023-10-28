package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();
    private final static int maxCarCount = 100;

    public void save(Car car) {
        validateDuplicateName(car.getName());
        this.cars.add(car);
    }

    private void validateDuplicateName(String carName) {
        if (cars.stream().anyMatch(car -> car.getName().equals(carName))) {
            throw new IllegalArgumentException("같은 이름의 자동차 이름이 존재합니다.");
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
