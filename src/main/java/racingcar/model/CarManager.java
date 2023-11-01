package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars = new ArrayList<>();

    public void addCar(String name) {
        if (isCarNameDuplicate(name)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 발견되었습니다.");
        }
        cars.add(new Car(name));
    }

    private boolean isCarNameDuplicate(String name) {
        return cars.stream().anyMatch(car -> car.getName().equals(name));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }
}

