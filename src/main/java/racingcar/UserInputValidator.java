package racingcar;

import java.util.regex.Pattern;

public class UserInputValidator {
    // 사용자로부터 입력받는 경주할 자동차 이름에 대해 validate
    public static String[] validateCarName(String userInput) {
        String[] carNames = userInput.split(",");

        String pattern = "^.{1,5}$";

        for (String carName : carNames) {
            if (!Pattern.matches(pattern, carName.trim())) {
                throw new IllegalArgumentException(carName.trim() + "는 5자를 초과하는 자동차 이름입니다. 다시 입력해주세요.");
            }
        }
        return carNames;
    }
}
