package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.Validation;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    public static final List<Car> cars = new ArrayList<>();

    public static void makeCar(String inputCarNames) {
        String[] carNames = InputView.splitInputCarNames(inputCarNames);
        Validation.valiEmptySplitInputCarNames(carNames);
        addCarsToList(carNames);
    }

    private static void addCarsToList(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            String carName = carNames[i].trim();
            Validation.valiCarName(carName.trim());
            cars.add(new Car(carName));
        }
    }
}
