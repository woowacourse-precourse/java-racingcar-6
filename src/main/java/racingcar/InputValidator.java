package racingcar;

import java.util.List;

public class InputValidator {
    public boolean isSingleCarInput(List<String> carNames) {
        return carNames.size() < 2;
    }

    public void checkForWhitespace(List<String> carNames) {
        for (String name : carNames) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException();
            }
        }
    }
}