package racingcar.model;

import java.util.List;

public class InputValidator {
    public InputValidator() {
    }

    public List<String> validateNamesOfCarFromPlayer(String carNames) {
        List<String> carNameList = List.of(carNames.split(","));
        for (String carName: carNameList) {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
        return carNameList;
    }

    public int validateNumberOfAttemptFromPlayer(String number) {
        try {
            int attemptNumber = Integer.parseInt(number);
            return attemptNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
