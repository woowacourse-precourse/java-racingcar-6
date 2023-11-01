package racingcar.validation;

import java.util.List;

public class Validation {

    public static boolean isLessThenSixLetters(List<String> carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(carName + "car name must be less or equal then five");
            }
        }
        return true;
    }

}
