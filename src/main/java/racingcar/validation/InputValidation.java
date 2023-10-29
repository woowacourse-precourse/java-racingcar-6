package racingcar.validation;

import java.util.HashMap;

public class InputValidation {
    public void inputCarNameLength(HashMap<String, Integer> carName) {
        for (String car : carName.keySet()) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("입력 값 길이는 5자 이하입니다.");
            }
        }
    }
}
