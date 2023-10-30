package racingcar.util;

public class GlobalExceptionHandler {

    public boolean isValidCarArray(String carArray) {
        if (carArray.contains(",")) {
            return true;
        }
        return false;
    }
}
