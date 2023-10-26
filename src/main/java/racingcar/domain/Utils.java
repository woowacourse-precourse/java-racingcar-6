package racingcar.domain;

public class Utils {

    public static int convertStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw numberFormatException;
        }
    }
}
