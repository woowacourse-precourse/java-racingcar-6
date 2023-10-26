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
}
