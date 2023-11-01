package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputConvertUtils {

    public static final String SPLITTER = ",";

    public static List<String> carNamesToList(String names) {
        return Arrays.stream(names.split(SPLITTER))
                .map(String::trim)
                .toList();
    }
}
