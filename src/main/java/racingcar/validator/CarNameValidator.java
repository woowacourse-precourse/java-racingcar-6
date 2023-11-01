package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    public void CheckCarNameLength(String carName) {
        if(carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 1자리부터 5자리까지만 입력하세요.");
        }
    }


    public void CheckCarNameNumber(String carName) {
        if(carName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("자동차 이름은 숫자를 포함할 수 없습니다.");
        }
    }

    public void CheckCarNameDuplication(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if( carNamesSet.size() < carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
    }
}
