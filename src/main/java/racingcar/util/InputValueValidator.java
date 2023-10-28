package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValueValidator {

    private boolean isDuplicateName(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        return set.size() == carNames.size();
    }
}
