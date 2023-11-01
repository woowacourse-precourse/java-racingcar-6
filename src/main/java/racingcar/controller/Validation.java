package racingcar.controller;

import java.util.HashSet;
import java.util.Set;
import racingcar.model.Car;

enum ValidationMessage {
    LENGTH_EXCEPTION("자동차의 이름은 5자 이하여야 합니다."),
    NON_INPUT_EXCEPTION("자동차의 이름을 입력해주세요."),
    DUPLICATION_EXCEPTION("중복된 자동차가 있습니다."),
    NON_CHARACTER_EXCEPTION("자동차의 이름은 알파벳으로만 구성되야 합니다."),
    NON_NUMERIC_EXCEPTION("시도 횟수는 1~9까지의 숫자를 입력해주세요.");

    private final String message;

    ValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class Validation {
    public static void validateLength() {
        for (String car : Car.getNames()) {
            if (car.length() > 5) {
                throw new IllegalArgumentException(ValidationMessage
                        .LENGTH_EXCEPTION
                        .getMessage());
            }
        }
    }

    public static void validateEmtpy() {
        if (Car.getNames().isEmpty()) {
            throw new IllegalArgumentException(ValidationMessage
                    .NON_INPUT_EXCEPTION
                    .getMessage());
        }
    }

    public static void validateDuplicate() {
        Set<String> checkForDuplicates = makeLowercase();

        if (checkForDuplicates.size() != Car.getSize()) {
            throw new IllegalArgumentException(ValidationMessage
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
                throw new IllegalArgumentException(ValidationMessage
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
            throw new IllegalArgumentException(ValidationMessage
                    .NON_NUMERIC_EXCEPTION
                    .getMessage());
        }
    }
}
