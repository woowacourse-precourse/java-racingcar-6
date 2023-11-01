package racingcar.util;

import static racingcar.constant.GameOptions.DELIMITER;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    /**
     * @return 길이 1 이상의 List<String>
     */
    public static List<String> parseCarName(String str) {
        List<String> carNames = Arrays.asList(str.split(DELIMITER));
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }
}
