package racingcar.utill;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public void validationCarName(String input) {
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        validationCarNamesLength(carNames);
        validationCarNamesListLength(carNames);
    }

    private void validationCarNamesLength(List<String> carNames) {
        carNames.stream().filter(name -> name.length() > 5)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
                });
    }

    private void validationCarNamesListLength(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_CARS.getMessage());
        }
    }

    public void validationCount(String input) {
        validationCountIsZero(input);
        validationCountNumeric(input);
    }

    private void validationCountNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }

    private void validationCountIsZero(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }
}
