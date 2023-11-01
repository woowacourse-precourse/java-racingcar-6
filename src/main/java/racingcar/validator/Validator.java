package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public boolean checkCharacterLimit(List<String> carNameList) {
        return carNameList.stream().anyMatch(str -> str.length() > 5);
    }

    public boolean checkDuplicateName(List<String> carNameList) {
        Set<String> uniqueNames = new HashSet<>(carNameList);
        return uniqueNames.size() < carNameList.size();
    }

    public boolean checkEmptyName(List<String> carNameList) {
        return carNameList.contains("");
    }

    public boolean isPositiveInteger(String input) {
        try {
            int num = Integer.parseInt(input);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
