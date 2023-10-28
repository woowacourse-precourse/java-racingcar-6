package racingcar;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import static racingcar.GameMessage.INPUT_LENGTH_EXCEPTION_MESSAGE;

public class Validator {

    public static Map<String, String> inputCarNames(Map<String, String> carNamesMap) {
        isValidLength(carNamesMap);
        return carNamesMap;
    }

    private static void isValidLength(Map<String, String> carNamesMap) {
        for (String carName : carNamesMap.keySet()) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MESSAGE);
            }
        }
    }
}
