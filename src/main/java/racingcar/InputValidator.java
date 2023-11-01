package racingcar;

import java.util.List;

public class InputValidator {
    public boolean isSingleCarInput(List<String> carNames) {
        return carNames.size() < 2;
    }
}