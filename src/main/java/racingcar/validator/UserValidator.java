package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserValidator {

    public void CheckCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 1자리부터 5자리까지만 입력하세요.");
        }
    }


    public void CheckCarNameNumber(String carName) {
        if (carName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("자동차 이름은 숫자를 포함할 수 없습니다.");
        }
    }

    public void CheckCarNameDuplication(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNamesSet.size() < carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
    }

    public void CheckGameNumberNull(String gameNumberInput) {
        if (gameNumberInput == "") {
            throw new IllegalArgumentException("시도 횟수는 공백을 입력할 수 없습니다.");
        }
    }

    public void CheckGameNumberIsNumber(String gameNumberInput) {
        for (int i = 0; i < gameNumberInput.length(); i++) {
            char c = gameNumberInput.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("시도 횟수에 숫자 이외의 문자가 포함되어 있습니다.");
            }
        }
    }
}
