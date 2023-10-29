package racingcar.utility;

import java.util.Arrays;
import java.util.List;

public final class Convertor {

    public static List<String> split(String string, String delimiter) {
        String[] strings = string.split(delimiter);
        return Arrays.stream(strings)
                .toList();
    }

}
