package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CarValidator {
    public static void isOnlyLowerCase(List<String> carNameList) {
        for (String carName : carNameList) {
            if (!Pattern.matches("^[a-z|,]*$", carName)) {
                throw new IllegalArgumentException("소문자로 입력하세요.");
            }
        }
    }

    public static void checkCarNameLength(List<String> carNameList) {
        for (String carName : carNameList) {
            if (!(carName.length() >= 1 && carName.length() <= 5)) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하여야 한다.");
            }
        }
    }


    public static void checkDuplicateCarName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 존재합니다.");
        }
    }
}
