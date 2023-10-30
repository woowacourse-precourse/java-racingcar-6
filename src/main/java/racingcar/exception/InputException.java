package racingcar.exception;

import java.util.List;

public class InputException {
    public static void validateInput(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능");
            }
        }
    }
}
