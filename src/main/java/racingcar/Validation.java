package racingcar;

import java.util.List;

public class Validation {

    public static void validateCarNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("입력한 이름이 없습니다.");
        }

        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("빈 이름은 입력할 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 최대 5자입니다.");
            }
        }
    }

    public static void validateGameCount(String input) {
        try {
            int inputNum = Integer.parseInt(input);

            if (inputNum <= 0) {
                throw new IllegalArgumentException("자연수만 입력할 수 있습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
