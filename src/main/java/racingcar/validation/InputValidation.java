package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {

    static final int MIN_NAME_LENGTH = 2;
    static final int MAX_NAME_LENGTH = 5;

    public void validateCarName(String userInput) {
        List<String> carNames = List.of(userInput.split(","));
        Set<String> uniqueNames = new HashSet<>(carNames);

        if (carNames.size() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }

        for (String carName : carNames) {
            if (carName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }

        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateRound(String userInput) {
        if (userInput.charAt(0) == '0') {
            throw new IllegalArgumentException();
        }

        String[] inputs = userInput.split("");

        for (String letter : inputs) {
            if (letter.charAt(0) < '0' || letter.charAt(0) > '9') {
                throw new IllegalArgumentException();
            }
        }
    }
}
