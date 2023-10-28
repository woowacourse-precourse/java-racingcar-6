package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public static List<String> validateCarNames(String input) {
        String[] splitInput = checkAtLeastOneName(input);
        return (List<String>) checkNameLengthLimit(splitInput);
    }

    private static String[] checkAtLeastOneName(String input) {
        String[] splitInput = input.split(",");
        if (splitInput.length == 0) {
            throw new IllegalArgumentException("하나 이상의 이름이 입력되어야 합니다.");
        }
        return splitInput;
    }

    private static List<String> checkNameLengthLimit(String[] splitInput) {
        List<String> carNames = new ArrayList<>();
        for (String carName : splitInput) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            carNames.add(carName);
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
