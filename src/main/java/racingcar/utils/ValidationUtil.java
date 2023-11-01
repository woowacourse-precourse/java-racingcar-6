package racingcar.utils;

public class ValidationUtil {

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void validateIsNumber() {

    }

}
