package racingcar.util;

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
}
