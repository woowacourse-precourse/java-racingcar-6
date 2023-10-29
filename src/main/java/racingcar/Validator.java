package racingcar;

import java.util.List;

public class Validator {
    public void hasSpace(String carNames) {
        if (carNames.contains(" ")) {
            throw new IllegalArgumentException("띄어쓰기를 제외하고 입력해주세요.");
        }
    }

    public void isLengthOverFive(List<String> carNames) {
        for (String str : carNames) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5자 이하로 입력해주세요.");
            }
        }
    }

    public void isNumber(String inputNumber) {
        if (inputNumber.matches("[^0-9]+")) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
