package racingcar.model;

import racingcar.dto.CarDto;
import racingcar.dto.CarGroupDto;
import racingcar.utils.Movement;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<String> names) {
        CarGroupValidator.validate(names);
        this.cars = generateCars(names);
    }

    private List<Car> generateCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(toList());
    }

    public void race(Movement movement) {
        for (Car car : cars) {
            car.go(movement.canMove());
        }
    }

    public List<String> findWinnerNames() {
        Car winCar = findMaxPositionCar();
        return cars.stream()
                .filter(car -> car.equals(winCar))
                .map(Car::getName)
                .collect(toList());
    }

    private Car findMaxPositionCar() {
        return Collections.max(cars, Comparator.comparingInt(Car::getPosition));
    }

    public CarGroupDto toDto() {
        List<CarDto> carDtos = cars.stream()
                .map(Car::toDto)
                .collect(toList());
        return new CarGroupDto(carDtos);
    }

    public List<Car> getCars() {
        return cars;
    }
}
