package racingcar.controller;

import java.util.List;

public class Validation {

    public static void validateLength(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

}
