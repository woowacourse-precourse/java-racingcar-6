package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateInput(String input) {
        if (!input.matches("^[가-힣a-zA-Z,]+$")) {
            throw new IllegalArgumentException("자동차 이름을 영문자,한글로만 구성하고 쉼표로만 구분해주세요.");
        }
    }

    public void validateCarNames(List<String> carNames) {
        checkCarNameLength(carNames);
        checkCarNameCounting(carNames);
        checkCarNameDuplicated(carNames);
    }

    private void checkCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() < 1 || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1~5자로 입력해주세요.");
            }
        }
    }

    private void checkCarNameCounting(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("경주를 하기 위해서 자동차 이름을 최소 2개는 입력해주세요.");
        }
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