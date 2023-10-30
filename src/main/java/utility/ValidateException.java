package utility;

import java.util.List;

public class ValidateException {
    public static void racingCarNameInvalid(List<String> carName) {
        for (String validatingCarName : carName) {
            if (validatingCarName.length() >= 6) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void numberOfRacingInvalid(String numberOfMatch) {
        try {
            Integer.parseInt(numberOfMatch);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
