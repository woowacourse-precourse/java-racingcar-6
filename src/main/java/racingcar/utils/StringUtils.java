package racingcar.utils;

public class StringUtils {
    public static int countOccurrences(String str, String target) {
        int count = 0;
        int idx = 0;

        while ((idx = str.indexOf(target, idx)) != -1) {
            idx += target.length();
            count++;
        }

        return count;
    }
}
