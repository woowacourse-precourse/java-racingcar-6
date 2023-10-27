package racingcar;

import java.util.List;

public class Validator {
    public static void isLengthOverFive(List<String> carNames) {
        for (String str : carNames) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5자 이하로 입력해주세요.");
            }
        }
    }
}
