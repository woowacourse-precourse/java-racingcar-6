package racingcar.util.io;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public static void validateCarNameInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }

    public static void validateCarNameLength(String input) {
        String[] names = input.split(",");
        List<String> nameList = Arrays.asList(names);
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이가 5자보다 깁니다.");
            }
        }
    }

    public static void validateMoveNumberInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        } else if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        } else if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("0 혹은 양수를 입력하세요");
        }
    }
}
