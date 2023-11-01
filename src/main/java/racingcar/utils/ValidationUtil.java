package racingcar.utils;

public class ValidationUtil {

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void validateIsNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

}
