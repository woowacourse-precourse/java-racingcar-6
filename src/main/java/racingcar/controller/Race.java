package racingcar.controller;

import static racingcar.validator.InputValidator.validateCarList;
import static racingcar.view.InputView.askCarList;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Race {
    public static void updateCarList() {
        String carListString = askCarList();
        validateCarList(carListString);
        List<Car> carList = new ArrayList<>();
    }
}
