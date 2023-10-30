package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import util.Parser;

public class Cars {
    private List<Car> cars;
    private final Parser parser = new Parser();

    public Cars(String carNames) {
        cars = parser.parseCarNames(carNames)
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());

    }

    public void moveCars() {
        cars.forEach(Car::moveByCondition);
    }

    public String toString() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars(){
        return cars;
    }


}
