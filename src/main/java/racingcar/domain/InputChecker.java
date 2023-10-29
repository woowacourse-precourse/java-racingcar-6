package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class InputChecker {
    static final String DELIMITER = ",";

    public static List<String> checkCharacter(String input) {
        if (!input.matches("^[\\w" + DELIMITER + "]+$")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return Arrays.asList(input.split(DELIMITER));
    }
}
