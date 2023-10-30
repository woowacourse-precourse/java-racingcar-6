package racingcar;

import static racingcar.constant.MessageConstants.NONE_INSTANTIABLE_CLASS;
import static racingcar.constant.MessageConstants.PARSE_CAR_NAME_DELIMITER;

import java.util.Collections;
import java.util.List;

public class Utils {

    private Utils() {
        throw new AssertionError(NONE_INSTANTIABLE_CLASS);
    }

    public static List<String> parseCarName(String input) {
        return List.of(input.split(PARSE_CAR_NAME_DELIMITER));
    }

}
