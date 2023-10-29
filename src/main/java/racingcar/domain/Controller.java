package racingcar.domain;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.Validator;

public class Controller {
    static Car car = new Car();
    private static final List<String> carNameList = car.getCarName();

    public static void validateCarNames() {
        if (!Validator.isCarNameOverFiveCharacters(carNameList)) {
            throw new IllegalArgumentException();
        }

        if (!Validator.validateDelimiter(carNameList)) {
            throw new IllegalArgumentException();
        }

        if (!Validator.isEmpty(carNameList)) {
            throw new IllegalArgumentException();
        }
    }

}
