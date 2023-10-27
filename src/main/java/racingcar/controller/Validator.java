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
}
