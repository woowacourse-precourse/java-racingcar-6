package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.dto.ResultCar;
import racingcar.dto.ResultCars;

public class Cars {

    private static final int FIRST_INDEX = 0;
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars.stream().map(Car::new).toList();
    }

    public List<Car> getCars() {
        new ArrayList<>(cars);
        return cars;
    }

    public ResultCars filterCarsWithMaxDistance() {
        final List<Car> sortedCars = sortedCarByDistance();
        int maxDistance = sortedCars.get(FIRST_INDEX).getDistance();
        final List<ResultCar> resultCars = getMaxDistanceCar(sortedCars, maxDistance);
        return new ResultCars(resultCars);
    }

    private List<ResultCar> getMaxDistanceCar(final List<Car> sortedCars, final int maxDistance) {
        return sortedCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(car -> new ResultCar(car.getName()))
                .toList();
    }

    private List<Car> sortedCarByDistance() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getDistance).reversed())
                .toList();
    }
}
