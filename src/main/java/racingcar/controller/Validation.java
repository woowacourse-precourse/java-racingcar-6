package racingcar.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static void validateLength(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public static void validateEmtpy(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름을 입력해주세요.");
        }
    }

    public static void validateDuplicate(List<String> cars) {
        Set<String> checkForDuplicates = makeLowercase(cars);

        if (checkForDuplicates.size() != cars.size()) {
            throw new IllegalArgumentException("중복된 자동차가 있습니다.");
        }
    }

    public static Set<String> makeLowercase(List<String> cars) {
        Set<String> lowercaseCars = new HashSet<>();

        for (String car : cars) {
            lowercaseCars.add(car.toLowerCase());
        }

        return lowercaseCars;
    }

    public static void validateCharacters(List<String> cars) {
        for (String car : cars) {
            if (!car.matches("[a-zA-Z]")) {
                throw new IllegalArgumentException("자동차의 이름은 알파벳으로만 구성되야 합니다.");
            }
        }
    }

    public static void validateNumber(String inputNumber) {
        if (!inputNumber.matches("[1-9]")) {
            throw new IllegalArgumentException();
        }
    }

}
