package racingcar.model.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.movement.Movement;
import racingcar.util.CarValidation;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        CarValidation.validateCars(carNames);
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void race(Movement movement) {
        cars.forEach(car -> car.moveForward(movement.canMove()));
    }

    public List<Car> getResult() {
        return cars;
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(this::isMostDistant)
                .collect(Collectors.toList());
    }

    private boolean isMostDistant(Car car) {
        return cars.stream()
                .filter(another -> !car.equals(another))
                .allMatch(car::isFurtherThan);
    }

}
