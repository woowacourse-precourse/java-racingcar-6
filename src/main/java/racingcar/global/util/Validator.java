package racingcar.global.util;

import racingcar.global.error.BusinessException;
import racingcar.global.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private final static String SYMBOL = ",";
    private final static int MAXIMUM_NAME_LENGTH = 5;

    public void validateCarsName(String carsName) {
        validateIsBlank(carsName);
        validateContainSymbol(carsName);
        validateSymbolPosition(carsName);
        validateMaximumLength(carsName);
        validateDuplicateName(carsName);
    }

    public void validateNumberOfAttempts(String numberOfAttempts) {
        try {
            int count = Integer.parseInt(numberOfAttempts);
            validateMinimumLimit(count);
        } catch (NumberFormatException e) {
            throw BusinessException.of(ErrorMessage.TYPE_MISMATCH);
        }
    }

    private void validateIsBlank(String carsName) {
        if (carsName.isBlank()) {
            throw BusinessException.of(ErrorMessage.IS_BLANK);
        }
    }

    private void validateContainSymbol(String carsName) {
        if (!carsName.contains(SYMBOL)) {
            throw BusinessException.of(ErrorMessage.NOT_CONTAIN_SYMBOL);
        }
    }

    private void validateSymbolPosition(String carsName) {
        if (carsName.startsWith(SYMBOL) || carsName.endsWith(SYMBOL)) {
            throw BusinessException.of(ErrorMessage.INVALID_SYMBOL_POSITION);
        }
    }

    private void validateMaximumLength(String carsName) {
        String[] names = carsName.split(SYMBOL);
        Arrays.stream(names)
                .forEach(name -> {
                    if (name.length() > MAXIMUM_NAME_LENGTH) {
                        throw BusinessException.of(ErrorMessage.INVALID_NAME_LENGTH);
                    }
                });
    }

    private void validateDuplicateName(String carsName) {
        String[] names = carsName.split(SYMBOL);
        List<String> seen = new ArrayList<>();
        Arrays.stream(names)
                .forEach(name -> {
                    if (seen.contains(name)) {
                        throw BusinessException.of(ErrorMessage.DUPLICATE_NAME);
                    }
                    seen.add(name);
                });
    }

    private void validateMinimumLimit(int count) {
        if (count < 1) {
            throw BusinessException.of(ErrorMessage.INVALID_COUNT);
        }
    }
}
