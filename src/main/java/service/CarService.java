package service;

import domain.Car;
import util.Validate;

import java.util.List;
import java.util.stream.Collectors;

import static util.Parser.splitCarNames;


public class CarService {
    Validate validate = new Validate();

    public List<String> getCarNames(String inputLineOfCarNames) {
        List<String> carNames = splitCarNames(inputLineOfCarNames);
        validate.CarNames(carNames);
        return carNames;
    }

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
