package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class CarNamesSeperator {
    private static final String DELIMITER = ",";

    public static List<String> separate(String userInputNames) {
        return Arrays.stream(userInputNames.split(DELIMITER)).toList();
    }
}