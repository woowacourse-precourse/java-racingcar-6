package racingcar.utils.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueNameValidator {

    public static boolean validate(List<String> inputs) {
        Set<String> uniqueNames = new HashSet<>(inputs);
        return uniqueNames.size() == inputs.size();
    }
}
