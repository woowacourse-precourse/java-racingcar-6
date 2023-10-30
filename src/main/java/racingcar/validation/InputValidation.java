package racingcar.validation;

import static racingcar.constant.ConstantNumber.*;

import java.util.HashMap;
import java.util.List;

public class InputValidation {
    public void inputCarNameLength(HashMap<String, Integer> carName) {
        for (String car : carName.keySet()) {
            if (car.length() > inputLength) {
                throw new IllegalArgumentException("입력 값 길이는 5자 이하입니다.");
            }
        }
    }

    public void inputCarNameDuplication(HashMap<String, Integer> carName, List<String> carNameList) {
        if (carName.size() != carNameList.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    public void inputCarNameBlank(HashMap<String, Integer> carName) {
        for (String car : carName.keySet()) {
            if (car.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 빈칸을 허용하지 않습니다.");
            }
        }
    }

    public void inputMovementLimit(long movement) {
        if (movement < 1 || movement > Long.MAX_VALUE) {
            throw new IllegalArgumentException("이동 횟수 입력 값이 범위는 1 ~ 9,223,372,036,854,775,807 입니다.");
        }
    }
}
