package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.validator.CarValidator;
import racingcar.manager.InputManager;

public class CarFactory {
    private InputManager inputManager = new InputManager();

    public List<Car> generateCars() {
        List<String> carNames = splitCarNamesToComma(inputManager.inputCarNames());
        List<Car> cars = new ArrayList<>();

        CarValidator.validateNumberOfCar(carNames);
        CarValidator.validateDuplicatedCarName(carNames);

        for (String carName : carNames) {

            CarValidator.validateCarName(carName);
            cars.add(new Car(carName));
        }

        return cars;
    }

    private List<String> splitCarNamesToComma(String inputCarNames) {
        return Arrays.stream(inputCarNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
