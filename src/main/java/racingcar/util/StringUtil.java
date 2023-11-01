package racingcar.util;

import java.util.List;

public class StringUtil {
    public static boolean isLengthOverFive(String s){
        return s.length() > 5;
    }

    public static boolean isBlank(String s) {
        return s.isBlank();
    }

    public static String concatTag(String s) {
        return s + " : ";
    }
    public static String drawLine(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public static String concatNamesByCommas(List<String> strings){
        final int FIRST_ELEMENT_INDEX = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            if (i == FIRST_ELEMENT_INDEX) {
                stringBuilder.append(strings.get(i));
                continue;
            }
            stringBuilder.append(", ").append(strings.get(i));
        }
        return stringBuilder.toString();
    }
}
