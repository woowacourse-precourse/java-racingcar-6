package racingcar.controller;

import java.util.HashSet;
import java.util.Set;
import racingcar.model.Car;
import racingcar.model.Messages;

public class Validation {
    public static void validateLength() {
        for (String car : Car.getNames()) {
            if (car.length() > 5) {
                throw new IllegalArgumentException(Messages
                        .LENGTH_EXCEPTION
                        .getMessage());
            }
        }
    }

    public static void validateEmtpy() {
        if (Car.getNames().isEmpty()) {
            throw new IllegalArgumentException(Messages
                    .NON_INPUT_EXCEPTION
                    .getMessage());
        }
    }

    public static void validateDuplicate() {
        Set<String> checkForDuplicates = makeLowercase();

        if (checkForDuplicates.size() != Car.getSize()) {
            throw new IllegalArgumentException(Messages
                    .DUPLICATION_EXCEPTION
                    .getMessage());
        }
    }

    public static Set<String> makeLowercase() {
        Set<String> lowercaseCars = new HashSet<>();

        for (String car : Car.getNames()) {
            lowercaseCars.add(car.toLowerCase());
        }

        return lowercaseCars;
    }

    public static void validateCharacters() {
        for (String car : Car.getNames()) {
            if (!car.matches("[a-zA-Z]*")) {
                throw new IllegalArgumentException(Messages
                        .NON_CHARACTER_EXCEPTION
                        .getMessage());
            }
        }
    }

    public static void validateCarName() {
        validateCharacters();
        validateLength();
        validateDuplicate();
        validateEmtpy();
    }

    public static void validateAttempNumber(int inputNumber) {
        if (inputNumber == 0) {
            throw new IllegalArgumentException(Messages
                    .NOT_ONE_TO_NINE_EXCEPTION
                    .getMessage());
        }
    }
}
