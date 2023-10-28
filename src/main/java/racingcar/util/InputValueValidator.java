package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValueValidator {

    private boolean isDuplicateName(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        return set.size() == carNames.size();
    }

    private boolean isNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }

    private List<String> converStringToList(String inputCarNames) {
        return Arrays.asList(inputCarNames.split(","));
    }
}
