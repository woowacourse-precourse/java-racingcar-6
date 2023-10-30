package racingcar.util;

import java.util.List;
import racingcar.model.Cars;

public class Validation {
    // indent depth = 2인 메서드임
    // 글자(CarNames) 입력 검증

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



}
