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

}
