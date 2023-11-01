package racingcar.util;

/**
 * Defines functions to deal with numbers.
 */
public class NumberUtil {

    /**
     * Check if the given string is an integer.
     * @param str to check.
     * @return true if the str is an integer, otherwise false.
     */
    public static boolean isInteger(String str) {
        try {
            Integer.valueOf(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
