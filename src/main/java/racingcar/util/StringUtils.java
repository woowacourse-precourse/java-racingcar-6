package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private static final String DISTANCE = "-";
    private static final String COMMMA = ",";

    public static String generateDashString(int count) {
        return DISTANCE.repeat(count);
    }

    public static List<String> splitStringToList(String str) {
        return Arrays.stream(str.split(COMMMA))
                .toList();
    }
}
