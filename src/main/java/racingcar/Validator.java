package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateInput(String input) {
        if (input.length() > 10000000) {
            throw new IllegalArgumentException("입력값이 너무 깁니다. 입력값의 길이는 최대 1000만자 입니다.");
        }
        if (input.matches("^[가-힣a-zA-Z,]+$")) {
            throw new IllegalArgumentException("자동차 이름을 영문자,한글로만 구성하고 쉼표로만 구분해주세요.");
        }
    }

    public void validateCarNames(List<String> carNames) {
        checkCarNameDuplicated(carNames);
    }

    private void checkCarNameDuplicated(List<String> carNames) {
        Set<String> duplicacySet = new HashSet<>();

        for (String carName : carNames) {
            duplicacySet.add(carName);
        }
        if (carNames.size() != duplicacySet.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되면 우승자를 확인하는데 어려움이 있으니 중복 없이 입력하세요.");
        }
    }
}