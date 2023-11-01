package racingcar.util;

import static racingcar.constant.ExceptionMessages.NAME_BLANK_MESSAGE;
import static racingcar.constant.ExceptionMessages.NEGATIVE_INTEGER_MESSAGE;
import static racingcar.constant.ExceptionMessages.NUMBER_FORMAT_MESSAGE;
import static racingcar.constant.ExceptionMessages.ZERO_NAME_MESSAGE;
import static racingcar.constant.GameOptions.DELIMITER;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    /**
     * @return 길이 1 이상의 List<String>
     */
    public static List<String> parseCarName(String str) {
        if (str.startsWith(DELIMITER) || str.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(NAME_BLANK_MESSAGE);
        }

        List<String> carNames = Arrays.asList(str.split(DELIMITER));
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ZERO_NAME_MESSAGE);
        }
        return carNames;
    }

    /**
     * @return 0 이상의 정수
     */
    public static Integer parseRound(String str) {
        try {
            int round = Integer.parseInt(str);
            if (round < 0) {
                throw new IllegalArgumentException(NEGATIVE_INTEGER_MESSAGE);
            }
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_MESSAGE);
        }
    }
}
