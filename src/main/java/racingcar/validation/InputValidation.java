package racingcar.validation;

import java.util.Arrays;
import java.util.List;

public class InputValidation {
    public void raiseErrorIfCarNameExceedsLimit(String inputNumberAttempts) {
        if (inputNumberAttempts == null) {
            throw new IllegalArgumentException();
        }

        List<String> inputNumberAttempt = Arrays.asList(inputNumberAttempts.split(","));
        inputNumberAttempt.forEach(item -> {
            if (item.length() > 5) {
                throw new IllegalArgumentException("String index out of range: 5");
            }
        });

    }

    public void raiseErrorIfAttemptCountIsInvalid(String inputValidation) {
        if (inputValidation == null) {
            throw new IllegalArgumentException();
        }
        if (inputValidation.matches("[a-z]+")) {
            throw new IllegalArgumentException("String out of numeric range");
        }
        if (Integer.valueOf(inputValidation) < 0) {
            throw new IllegalArgumentException("String out of integer range");
        }

    }
}
