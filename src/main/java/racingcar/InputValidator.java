package racingcar;

import java.util.List;

public class InputValidator {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
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

    public void checkNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }
}