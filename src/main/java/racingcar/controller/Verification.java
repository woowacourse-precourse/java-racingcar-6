package racingcar.controller;

import java.util.List;

public class Verification {
    public void CarName(List<String> carNames) {
        for (String name : carNames) {
            if (name.contains(" ") || name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void Round(String input) {
        if (input.matches("^[\\D]*$")) {
            throw new IllegalArgumentException();
        }
    }
}
