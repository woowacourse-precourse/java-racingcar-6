package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;

public class CarCreator {
    public static Cars createCars() {
        return new Cars(createCarList());
    }

    private static List<Car> createCarList() {
        String inputName = InputView.inputName();
        List<String> names = StringName.splitName(inputName);
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
