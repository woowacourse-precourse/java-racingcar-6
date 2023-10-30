package racingcar.domain;

import racingcar.util.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] names) {
        this.cars = Arrays.stream(names)
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    public void moveCars() {
        RandomNumbersGenerator.randomNumberGenerator(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
