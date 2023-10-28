package racingcar.view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputVerification {

    public boolean isCarNameInputLengthValid(String carName) {
        if (carName.length() == 0 || carName.length() > 5) {
            throw new IllegalArgumentException("옳지 않은 입력 길이입니다.");
        }
        return true;
    }

    public boolean isCarNameInputDuplicateValid(List<String> carNames) {
        Set<String> uniqueCarName = new HashSet<>();

        for (String carName : carNames) {
            if(uniqueCarName.contains(carName))
                throw new IllegalArgumentException("중복된 차 이름이 포함되어 있습니다.");
            uniqueCarName.add(carName);
        }

        return true;
    }

    public boolean verifyCarNamesInput(List<String> carNames) {
        boolean isValid = true;

        for(String car : carNames) {
            isValid = isCarNameInputLengthValid(car);
        }
        isValid = isCarNameInputDuplicateValid(carNames);

        return isValid;
    }
}
