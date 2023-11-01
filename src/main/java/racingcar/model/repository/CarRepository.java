package racingcar.model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.domain.Car;

public class CarRepository {
    List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
    }

    public void save(String name) {
        cars.add(new Car(name));
    }

    public Car carForward(int idx, int randomNumber) {
        final int FORWARD_CONDITION = 4;
        Car currentCar = cars.get(idx);
        if (randomNumber>= FORWARD_CONDITION) {
            currentCar.setForward(currentCar.getForward() + 1);
        }
        return currentCar;
    }

    public List<String> findAllMaxForward() {
        int maxForward = cars.stream()
                .mapToInt(Car::getForward)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getForward() == maxForward)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Car findByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
