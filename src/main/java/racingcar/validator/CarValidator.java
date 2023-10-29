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
}
