package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class RacingGameUtil {
    public static final String CARNAME_DELIMITER = ",";

    public static List<String> splitCarNames(String carnames) {
        return Arrays.asList(carnames.split(CARNAME_DELIMITER));
    }
}
