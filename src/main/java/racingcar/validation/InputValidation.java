package racingcar.validation;

import racingcar.constant.RacingConstant;

import java.util.*;

public class InputValidation {

    public void isNameValid(String name) {
        if (name.length() > RacingConstant.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void hasDuplicateNames(String[] names) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        if (uniqueNames.size() < names.length) {
            throw new IllegalArgumentException("차량의 이름이 중복되었습니다.");
        }
    }
}
