package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = createCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = mapCarNamesToCars(carNames);
        return cars;
    }

    private List<Car> mapCarNamesToCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = createCar(carName);
            cars.add(car);
        }
        return cars;
    }

    private Car createCar(String carName) {
        return new Car(carName);
    }

    public void playOneRound() {
        cars.forEach(Car::move);
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition(cars);
        return findCarNamesWithMaxPosition(maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private List<String> findCarNamesWithMaxPosition(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
