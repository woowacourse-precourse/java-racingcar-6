package racingcar.domain;

import racingcar.exception.CarsExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.domain.CarSetting.*;
import static racingcar.exception.CarsExceptionMessage.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names, MovingStrategy movingStrategy) {
        validateDuplicateName(names);
        this.cars = createCars(names, movingStrategy);
    }

    public void raceAllCars() {
        for (Car car : cars) {
            car.goForward();
        }
    }


    public Integer findWinnerPosition() {
        return cars.stream().max(Car::compareTo)
                            .get()
                            .getPosition();
    }

    public List<Car> findWinner(Integer winnerPosition) {
        return cars.stream()
                .filter(car -> car.isWinner(winnerPosition))
                .collect(Collectors.toList());
    }



    private List<Car> createCars(List<String> names, MovingStrategy movingStrategy) {
        return names.stream()
                .map(name -> new Car(movingStrategy, name))
                .collect(Collectors.toList());
    }

    private void validateDuplicateName(List<String> names) {
        if (names.stream()
                .collect(Collectors.toSet()).size() != names.size()) {
            throw new IllegalArgumentException(ERROR_NAME_DUPLICATED.getMessage());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
