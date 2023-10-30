package racingcar.util;

public class GlobalExceptionHandler {

    public boolean isValidCarArray(String carArray) {
        if (carArray.contains(",")) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isValidCarName(String carName) {
        if (carName.length()<=5) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
