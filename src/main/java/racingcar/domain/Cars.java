package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;
import racingcar.dto.ResultCar;
import racingcar.dto.ResultCars;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars.stream().map(Car::new).toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public ResultCars filterCarsWithMaxDistance() {
        List<Car> sortedCars = cars.stream()
                .sorted(Comparator.comparingInt(Car::getDistance).reversed())
                .toList();
        int maxDistance = sortedCars.get(0).getDistance();

        List<ResultCar> resultCarList = sortedCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(car -> new ResultCar(car.getName()))
                .toList();

        return new ResultCars(resultCarList);
    }
}
