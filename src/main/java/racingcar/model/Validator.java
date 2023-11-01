package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateCarName(List<String> carNameList) {

        for(String carName : carNameList) {
            if(carName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에는 공백을 포함할 수 없습니다.");
            }
            if(carName.length() < 1) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
            if(carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public void isCarNameUnique(List<String> idList) {
        Set<String> set = new HashSet<>();

        for (String id : idList) {
            if (!set.add(id)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    public void validateAttemptInput(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1회 이상이여야 합니다.");
        }
    }

}
