package racingcar.dto;

import racingcar.model.Car;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarsDto {
    static Map<String, Car> cars = new HashMap();

    public void enrollCar(String carName) {
        if(findCarByName(carName).equals(Optional.empty())) {
            cars.put(carName, new Car(carName, 0));
        }
    }

    public Optional<Integer> findPositionByName(String name) {
        return Optional.ofNullable(cars.get(name).getPosition());
    }

    public Optional<Car> findCarByName(String name) {
        return Optional.ofNullable(cars.get(name));
    }

    public Map<String, Integer> findAll() {
        return cars.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getPosition()));
    }

    public void increaseCarPosition(String carName) {
        findCarByName(carName).ifPresent(car -> car.setPosition(car.getPosition() + 1));
    }
}
