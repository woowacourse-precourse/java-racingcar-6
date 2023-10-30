package racingcar.util;

public class GlobalExceptionHandler {

    public boolean isValidCarArray(String carArray) {
        if (!",".contains(carArray)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isValidCarName(String carName) {
        if (carName.length()>5) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isValidRacingCount(String racingCount) {
        try {
            Integer.parseInt(racingCount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
