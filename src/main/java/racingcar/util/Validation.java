package racingcar.util;

import java.util.List;
import racingcar.model.Cars;

public class Validation {
    // indent depth = 2인 메서드임
    // 글자(CarNames) 입력 검증

    public static void validateNameInput(String input) {
        validateStringNull(input);
        List<String> list = Cars.makeCarList(input);
        validateNameLength(list);
        validateDuplicateName(list);
    }

    private static void validateStringNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈칸입니다.");
        }
    }

    private static void validateNameLength(List<String> list) {
        for (String input : list) {
            if (input.length() > 5) {
                throw new IllegalArgumentException("5자 이하의 이름만 입력 가능합니다");
            }
        }
    }

    private static void validateDuplicateName(List<String> list) {
        if (list.size() != list.stream().distinct().count()) {
            throw new IllegalArgumentException("이름이 중복되었습니다.");
        }
    }

    private static void validateNumberNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈칸입니다.");
        }
    }

    private static void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }



}
