package racingcar.util;

import java.util.Arrays;

public class Validator {
    private final static String SYMBOL = ",";
    private final static int MAXIMUM_NAME_LENGTH = 5;

    private void validateIsBlank(String carsName) {
        if (carsName.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 공백일 수 없습니다.");
        }
    }

    private void validateContainSymbol(String carsName) {
        if (!carsName.contains(SYMBOL)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSymbolPosition(String carsName) {
        if (carsName.startsWith(SYMBOL) || carsName.endsWith(SYMBOL)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMaximumLength(String carsName) {
        String[] names = carsName.split(SYMBOL);
        Arrays.stream(names)
                .forEach(name -> {
                    if (name.length() > MAXIMUM_NAME_LENGTH) {
                        throw new IllegalArgumentException();
                    }
                });
    }
}
