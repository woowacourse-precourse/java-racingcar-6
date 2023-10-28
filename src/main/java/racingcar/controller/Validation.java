package racingcar.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static void validateLength(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateEmtpy(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(List<String> cars) {
        Set<String> checkForDuplicates = new HashSet<>(cars);

        if (checkForDuplicates.size() != cars.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCharacters(List<String> cars) {
        for (String car : cars) {
            if (!car.matches("[a-zA-Z]")) {
                throw new IllegalArgumentException();
            }
        }
    }

}
