package racingcar.Controller;

import java.util.List;

public class Verification {
    public void verifyCarName(List<String> carNames) {
        for (String name : carNames) {
            if (name.contains(" ") || name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void verifyTryCnt(String input) {
        if (input.matches("^[\\D]*$")) {
            throw new IllegalArgumentException();
        }
    }
}
