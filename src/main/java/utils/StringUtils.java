package utils;

import java.util.*;

public class StringUtils {
    public static String joinWithoutBlank(List<String> stringList) {
        return String.join(",", stringList);
    }

    public static String joinWithBlank(List<String> stringList) {
        return String.join(", ", stringList);
    }
}
