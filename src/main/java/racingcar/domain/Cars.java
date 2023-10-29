package racingcar.domain;

import racingcar.dto.CarDto;

import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars(String inputNames) {

        String[] names = Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        validateDuplicateName(names);

        cars = Arrays.stream(names)
                .map(name -> new Car(name))
                .toList();
    }

    private void validateDuplicateName(String[] names) {

        Set<String> notDuplicateNames = new HashSet<>();
        Arrays.stream(names)
                .forEach(name -> notDuplicateNames.add(name));

        if(notDuplicateNames.size() != names.length) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {

        cars.stream()
                .forEach(car -> car.play());
    }

    public List<String> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return findMaxPositionCarList(maxPositionCar);
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max((car, other) -> car.compareTo(other))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private List<String> findMaxPositionCarList(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> maxPositionCar.isSamePosition(car))
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<CarDto> toDto() {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .toList();
    }
}
