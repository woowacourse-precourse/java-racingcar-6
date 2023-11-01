package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateNameValidator implements Validator {
    @Override
    public boolean isValid(List<String> carNameList) {
        Set<String> uniqueNames = new HashSet<>(carNameList);
        return uniqueNames.size() < carNameList.size();
    }
}
