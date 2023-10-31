package racingcar.service;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameService {
    public List<Car> makeCars(String[] carNames){
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }
    private Integer findMaxPlace(List<Car> cars){
        return cars.stream()
                .map(Car::getPlace)
                .max(Integer::compare)
                .orElse(0);
    }
    public List<String> findEqualsMaxPlace(List<Car> cars){
        return cars.stream()
                .filter(car -> Objects.equals(car.getPlace(), findMaxPlace(cars)))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
