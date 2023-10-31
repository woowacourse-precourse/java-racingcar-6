package racingcar.validation;

import java.util.List;

public class Validator {
    public static void validateCarsInput(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

}
