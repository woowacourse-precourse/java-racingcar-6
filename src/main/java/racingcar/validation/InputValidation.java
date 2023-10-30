package racingcar.validation;

import racingcar.constant.ConstantNumber;

import static racingcar.constant.ConstantNumber.*;

import java.util.HashMap;
import java.util.List;

public class InputValidation {
    public void inputCarNameLength(HashMap<String, Integer> carName) {
        for (String car : carName.keySet()) {
            if (car.isEmpty() || car.length() > inputLength) {
                throw new IllegalArgumentException("입력 값 길이 범위는 1 ~ 5자 입니다.");
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

    public void inputMovementLimit(String movement) {
        try {
            long move = Long.parseLong(movement);
            if (move < movelowerBound) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("이동 횟수 입력 값의 범위는 1 ~ 9,223,372,036,854,775,807 (정수) 입니다.");
        }
    }
}
