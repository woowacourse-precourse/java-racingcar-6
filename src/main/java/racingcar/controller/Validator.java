package racingcar.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void isUnique(List<String> carName) {
        Set<String> unique = new HashSet<>(carName);
        if (unique.size() != carName.size()) {
            throw new IllegalArgumentException("중복이 존재합니다.");
        }
    }

    public static void isValidLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void isBlankCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("공백만 입력할 수 없습니다.");
            }
        }
    }
}
