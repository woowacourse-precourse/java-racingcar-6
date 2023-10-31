package racingcar.domain;

import java.util.List;

public class InputValidator {

    public static void validate(List<Car> carList) throws IllegalArgumentException {
        for (Car car : carList) {
            if (car.getName().length() > 5)
                throw new IllegalArgumentException();
        }
    }
}
