package racingcar.domain;

import racingcar.validator.InputValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Setting {
    static List<Car> cars = new ArrayList<>();

    public static List<Car> initCar() {
        List<String> carNames = InputValidator.filterCarName(initCarName());
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private static List<String> initCarName() {
        List<String> carNameList = new ArrayList<>();
        String[] carNames = InputView.inputCarName();
        for (String carName : carNames) {
            carNameList.add(carName);
        }
        return carNameList;
    }

    public static int initNumberOfAttempt() {
        return InputValidator.filterNumberOfAttempt(InputView.inputNumberOfAttempts());
    }
}
