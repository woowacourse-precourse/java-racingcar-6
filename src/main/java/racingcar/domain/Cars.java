package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> list) {
        this.cars = list;
    }

    public List<Car> findWinners() {
        Car maxPositionedCar = findMaxPositionedCar();
        Position maxPosition = maxPositionedCar.getPosition();

        return cars.stream()
            .filter(car -> car.getPosition().equals(maxPosition))
            .collect(Collectors.toList());
    }

    public void printCarNamesAndPositions() {
        cars.forEach(Car::printCarNameAndPosition);
    }

    public void moveAllCars(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); ++i) {
            cars.get(i).move(randomNumbers.get(i));
        }
    }

    public static Cars createdByName(List<String> carNames) {
        List<Car> list = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());

        return new Cars(list);
    }

    private Car findMaxPositionedCar() {
        return cars.stream()
            .max((a, b) -> a.compareTo(b))
            .get();
    }
}
