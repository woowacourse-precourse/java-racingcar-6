package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.exception.Validator;
import racingcar.manager.InputManager;

public class CarFactory {
    private InputManager inputManager = new InputManager();

    public List<Car> generateCars() {
        List<String> carNames = List.of(inputManager.inputCarNames().split(","));
        List<Car> cars = new ArrayList<>();

        Validator.validateNumberOfCar(carNames);

        for (String carName : carNames) {

            Validator.validateCarName(carName);
            cars.add(new Car(carName));
        }

        return cars;
    }
}
