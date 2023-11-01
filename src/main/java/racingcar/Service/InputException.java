package racingcar.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Rule;

public class InputException {
    public void validCarNameRange(List<String> names) {
        for (String name : names) {
            if (name.length() > Rule.maxCarName) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validCarNameDuplicated(List<String> names) {
        Set<String> setNames = new HashSet<>(names);
        if (setNames.size() != names.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int changeStringToInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
