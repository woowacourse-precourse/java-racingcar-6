package racingcar;

public class Util {
    public static boolean isNullOrEmpty(String string) {
        if (string == null) {
            return true;
        }
        if (string.isEmpty()) {
            return true;
        }
        if (string.isBlank()) {
            return true;
        }
        return false;
    }
}
