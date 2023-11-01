package racingcar;

import java.util.List;

public class Exception {
    public void isValidName(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("잘못된 입력입니다. (5글자 초과)");
            }
        }
    }

    public void isValidNumber(String input) {
        try {
            int cnt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. (숫자가 아님)");
        }
    }
}
