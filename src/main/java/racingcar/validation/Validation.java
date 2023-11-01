package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static boolean areLessThenSixLetters(List<String> carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(carName + "car name must be less or equal then five");
            }
        }
        return true;
    }

    public static boolean containDuplicateCarName(List<String> carNames) throws IllegalArgumentException {
        Set<String> carNameSet = new HashSet<>(carNames);

        if (carNameSet.size() != carNames.size()) {
            throw new IllegalArgumentException("car name must be unique");
        }
        return false;
    }
}
