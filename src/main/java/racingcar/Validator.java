package racingcar;

import java.util.*;

import static racingcar.GameMessage.INPUT_LENGTH_EXCEPTION_MESSAGE;
import static racingcar.GameMessage.INPUT_DUPLICATE_EXCEPTION_MESSAGE;

public class Validator {
    public static List<String> inputCarNames(String inputCarNames) {
        List<String> carNamesList = InputConvertor.toList(inputCarNames);
        isValidLength(carNamesList);
        isValidDuplicate(carNamesList);
        return carNamesList;
    }

    private static void isValidLength(List<String> carNamesList) {
        for (String carName : carNamesList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MESSAGE);
            }
        }
    }

    private static void isValidDuplicate(List<String> carNamesList) {
        Set<String> validDuplicate = new HashSet<>(carNamesList);
        if (validDuplicate.size() != carNamesList.size()) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
}
