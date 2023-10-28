package racingcar.validation;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    void checkNullInput(String in) throws IllegalArgumentException {
        if (in == null || in.isEmpty()) {
            throw new IllegalArgumentException("아무 입력도 들어오지 않았습니다.");
        }
    }

    List<String> splitNames(String in) {
        return Arrays.asList(in.split(",", -1));
    }
}
