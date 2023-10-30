package utils;

import java.util.List;

public class StringUtils {
    public static List<String> splitStringToArray(String strings, String standard) {
        return List.of(strings.split(","));
    }
}
