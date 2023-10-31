package racingcar;

public class Validation {

    public static void validateCarName(String carName) throws IllegalArgumentException {

        if (carName.isEmpty() || carName.length() >= 5) {
            throw new IllegalArgumentException();
        }
    }

}
