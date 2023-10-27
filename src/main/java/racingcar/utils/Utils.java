package racingcar.utils;

public class Utils {
    public static boolean wordLengthCheck(String name) {
        if (name.length() > 5) {
            return false;
        }
        return true;
    }
}
