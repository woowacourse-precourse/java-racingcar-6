package controller;

import domain.Car;
import infra.RandomCarEngine;
import java.util.List;

public class CarFactory {

    public List<Car> generateCars(final List<String> carNames) {
        return carNames.stream().map(name -> new Car(name, new RandomCarEngine())).toList();
    }

}
