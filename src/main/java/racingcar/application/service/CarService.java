package racingcar.application.service;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarEngine;
import racingcar.domain.car.NumberGeneratorEngine;
import racingcar.domain.util.NumberGenerator;

import java.util.List;

public class CarService {
    private final CarEngine engine;

    public CarService(NumberGenerator numberGenerator) {
        this.engine = new NumberGeneratorEngine(numberGenerator);
    }

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(this::createCar)
                .toList();
    }

    private Car createCar(String name) {
        return new Car(name, engine);
    }
}
