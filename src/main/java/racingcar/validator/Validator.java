package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public boolean isTryNumInteger(String tryNum) {
        try {
            Integer.parseInt(tryNum);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean isTryNumPositiveNum(Integer tryNum) {
        return tryNum > 0;
    }

    public boolean checkCarNameLength(String carName) {
        return 0 < carName.length() && carName.length() <= 5;
    }

    public boolean checkDuplicateCarName(List<String> carNameList) {

    }
}
