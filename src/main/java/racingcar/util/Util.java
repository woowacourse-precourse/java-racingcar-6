package racingcar.util;

public class Util {
    public boolean isNullOrEmpty(String string) {
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
