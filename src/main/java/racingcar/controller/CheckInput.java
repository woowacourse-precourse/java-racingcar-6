package racingcar.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckInput {

    public static void checkNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkDuplicateName(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() != nameSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfNum(String sNum) {
        try {
            Integer.parseInt(sNum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }
}
