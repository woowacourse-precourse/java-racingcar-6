package racingcar.util;

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
            throw new IllegalArgumentException("시도할 회수는 숫자만 입력 가능합니다.");
        }
    }

    private void validateIsBlank(String carsName) {
        if (carsName.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 공백일 수 없습니다.");
        }
    }

    private void validateContainSymbol(String carsName) {
        if (!carsName.contains(SYMBOL)) {
            throw new IllegalArgumentException("자동차의 이름은 쉼표(,)를 포함해야 합니다.");
        }
    }

    private void validateSymbolPosition(String carsName) {
        if (carsName.startsWith(SYMBOL) || carsName.endsWith(SYMBOL)) {
            throw new IllegalArgumentException("쉼표(,)는 처음과 끝 위치에 올 수 없습니다.");
        }
    }

    private void validateMaximumLength(String carsName) {
        String[] names = carsName.split(SYMBOL);
        Arrays.stream(names)
                .forEach(name -> {
                    if (name.length() > MAXIMUM_NAME_LENGTH) {
                        throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
                    }
                });
    }

    private void validateDuplicateName(String carsName) {
        String[] names = carsName.split(SYMBOL);
        List<String> seen = new ArrayList<>();
        Arrays.stream(names)
                .forEach(name -> {
                    if (seen.contains(name)) {
                        throw new IllegalArgumentException("자동차의 이름은 중복을 허용하지 않습니다.");
                    }
                    seen.add(name);
                });
    }

    private void validateMinimumLimit(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("시도할 회수는 최소 1회 이상입니다.");
        }
    }
}
