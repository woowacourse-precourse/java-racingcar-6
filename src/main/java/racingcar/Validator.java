package racingcar;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import static racingcar.GameMessage.INPUT_DUPLICATE_EXCEPTION_MESSAGE;
import static racingcar.GameMessage.INPUT_LENGTH_EXCEPTION_MESSAGE;

public class Validator {

    public static Map<String, String> inputCarNames(Map<String, String> racingCars) {
        isValidLength(racingCars);
        return racingCars;
    }

    private static void isValidLength(Map<String, String> racingCars) {
        for (String carName : racingCars.keySet()) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MESSAGE);
            }
        }
    }

    public static void  isDuplicateNames() {
        throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION_MESSAGE);
    }
}
