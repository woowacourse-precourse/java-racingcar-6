package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    private final static int MIN_CAR_NUM = 2;

    public boolean isIdentifierComma(String carNameInput){
        String regex = "([0-9a-zA-Zㄱ-ㅎ가-힣]+,)*[0-9a-zA-Zㄱ-ㅎ가-힣]+";
        return carNameInput.matches(regex);
    }

    public boolean isCarNameLength(String carName) {
        return 0 < carName.length() && carName.length() <= 5;
    }

    public boolean isDuplicateCarName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() != carNameList.size();
    }

    public boolean isCarMoreThanOne(List<String> carNameList) {
        return carNameList.size() >= MIN_CAR_NUM;
    }

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
}
