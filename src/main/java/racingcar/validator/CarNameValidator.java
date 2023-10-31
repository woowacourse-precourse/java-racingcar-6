package racingcar.validator;

import java.util.HashSet;
import java.util.Map;

public class CarNameValidator {

    public void checkCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5 이하로 설정 해주세요.");
        }
    }

    public void checkDuplicatedCarName(Map<String, Integer> list) {
        HashSet<String> nameSet = new HashSet<>(list.keySet());
        if (list.size() != nameSet.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다");
        }
    }
}
