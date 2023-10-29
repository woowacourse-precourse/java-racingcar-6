package racingcar.validator;

import java.util.List;
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
}
