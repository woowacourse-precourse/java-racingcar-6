package racingcar.model;

import java.util.HashMap;
import java.util.Set;

public class Validator {

    //이름 중복여부 체크 로직 추가 필요
    public void validateCarName(HashMap<String, String> carMap) {
        Set<String> carNameSet = carMap.keySet();

        for(String carName : carNameSet) {
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

    public void validateAttemptInput(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1회 이상이여야 합니다.");
        }
    }

}
