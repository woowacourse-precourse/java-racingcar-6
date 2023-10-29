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

    }

    public boolean checkCarNameLength(String carName) {

    }

    public boolean checkDuplicateCarName(List<String> carNameList) {

    }
}
