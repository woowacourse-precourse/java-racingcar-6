package racingcar;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

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

    public void checkForDuplicates(List<String> carNames) {
        Set<String> set = new HashSet<>();
        for (String name : carNames) {
            if (!set.add(name)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            }
        }
    }
}