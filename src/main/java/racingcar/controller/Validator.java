package racingcar.controller;

import java.util.List;

public class Validator {
    public static void validateInputCarList(List<String> list) {
        for (String s : list) {
            if (s.length() > 5)
                throw new IllegalArgumentException();
        }
    }
}