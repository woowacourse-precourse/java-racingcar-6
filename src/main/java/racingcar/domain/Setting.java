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
        String carNames = InputView.inputCarName();
        return Input.getSplitList(carNames);
    }

    public static int initNumberOfAttempt() {
        return InputValidator.filterNumberOfAttempt(InputView.inputNumberOfAttempts());
    }
}
