package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;
import racingcar.model.car.Car;
import racingcar.model.car.CarDTO;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names, NumberGenerator numberGenerator) {
        validateDuplicate(names);
        cars = names.stream()
                .map(name -> new Car(name, numberGenerator))
                .toList();
    }

    private void validateDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATE_ERROR.getMessage());
        }
    }

    public void move() {
        cars.forEach(Car::moveOneStep);
    }

    public List<CarDTO> getStatus() {
        return cars.stream()
                .map(Car::toCarDTO)
                .toList();
    }

    public List<CarDTO> judge() {
        int maxStep = getMaxStep();
        return cars.stream()
                .filter(car -> car.compare(maxStep))
                .map(Car::toCarDTO)
                .toList();
    }

    private int getMaxStep() {
        return cars.stream()
                .mapToInt(Car::getStep)
                .max()
                .orElse(0);
    }


}
