package racingcar.controller;

import java.util.List;

public class Validator {

    public static void validateInputCarList(List<String> list) {
        for (String s : list) {
            if (s.length() > 5)
                throw new IllegalArgumentException();
        }
    }

    public static int validateInputAttemptNum(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }
}