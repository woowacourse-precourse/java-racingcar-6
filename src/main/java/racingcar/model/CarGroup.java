package racingcar.model;

import racingcar.dto.CarDto;
import racingcar.dto.CarGroupDto;
import racingcar.utils.Movement;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CarGroup {
    private final List<Car> cars;
    private Movement movement;

    public CarGroup(List<String> names, Movement movement) {
        CarGroupValidator.validate(names);
        this.cars = generateCars(names);
        this.movement = movement;
    }

    private List<Car> generateCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(toList());
    }

    public void race() {
        for(Car car: cars){
            if(movement.canMove()){
                car.go();
            }
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
        return cars.stream()
                .max((car, compareCar) -> car.comparePosition(compareCar))
                .get();
    }

    public CarGroupDto toDto() {
        List<CarDto> carDtos = cars.stream()
                .map(car -> car.toDto())
                .collect(toList());
        return new CarGroupDto(carDtos);
    }
}
