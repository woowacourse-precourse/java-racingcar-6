package racingcar.domain;

import static racingcar.view.InputView.inputAttemptsCount;

import java.util.Arrays;
import java.util.Collections;
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

    public static void validateInputAttemptsCount() {
        String inputAttemptsCount = inputAttemptsCount();
        if (!Validator.isNonNumericInput(inputAttemptsCount)) {
            throw new IllegalArgumentException();
        }

        if (!Validator.isEmpty(Collections.singletonList(inputAttemptsCount))) {
            throw new IllegalArgumentException();
        }
    }
}
