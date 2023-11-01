package racingcar.utils;

public class ValidateUtil {

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void validateIsNumber() {

    }

}
