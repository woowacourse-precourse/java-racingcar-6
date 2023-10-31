package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    public static List<String> validateCarNames(String input) {
        String[] splitInput = input.split(",");
        List<String> carNames = checkNameLengthLimit(splitInput);
        return checkAtLeastOneName(carNames);
    }

    private static List<String> checkNameLengthLimit(String[] splitInput) {
        List<String> carNames = new ArrayList<>();
        for (String carName : splitInput) {
            carName = carName.trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            } else if (!carName.isEmpty()) {
                carNames.add(carName);
            }
        }
        return carNames;
    }

    private static List<String> checkAtLeastOneName(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("이름이 없습니다.");
        }
        return carNames;
    }

    public static int validateNumberOfAttempts(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }

        int number = Integer.parseInt(input);
        if (number <= 0) {
            throw new IllegalArgumentException("양의 정수가 아닙니다.");
        }
        return number;
    }
}
