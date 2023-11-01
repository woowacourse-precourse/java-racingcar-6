package racingcar;

import java.util.regex.Pattern;

public class UserInputValidator {
    // 사용자로부터 입력받는 경주할 자동차 이름에 대해 validate
    public static String[] validateCarName(String userInput) {
        String[] carNames = userInput.split(",");
        // car의 이름이 5자 이하이도록 체크하는 정규패턴
        String pattern = "^.{1,5}$";

        for (String carName : carNames) {
            if (!Pattern.matches(pattern, carName.trim())) {
                throw new IllegalArgumentException(carName.trim() + "는 5자를 초과하는 자동차 이름입니다. 다시 입력해주세요.");
            }
        }
        return carNames;
    }
    // 사용자로부터 입력받는 게임 횟수에 대해 validate
    public static int validateGameNumber(String userInput) {
        // 사용자 입력이 1이상의 정수인지 체크하는 정규패턴
        if(userInput.matches("^[1-9]\\d*$")) {
            return Integer.parseInt(userInput);
        }else {
            throw new IllegalArgumentException("입력한 값이 올바르지 않습니다. 1이상의 정수를 입력해주세요.");
        }
    }
}
