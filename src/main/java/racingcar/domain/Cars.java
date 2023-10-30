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


    public Cars(List<Car> cars) {
        this.cars = cars;
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



    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
