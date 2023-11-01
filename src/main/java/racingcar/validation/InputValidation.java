package racingcar.validation;

import racingcar.constant.RacingConstant;

public class InputValidation {

    public void isNameValid(String name) {
        if (name.length() > RacingConstant.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
