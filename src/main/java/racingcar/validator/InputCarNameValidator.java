package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import racingcar.util.ConverterUtil;

public class InputCarNameValidator {

    public void validateCarName(String carNames) {
        if (!isCorrectCarLength(carNames)) {
            throw new IllegalArgumentException("자동차이름은 1~5자이하여야 합니다.");
        }
        if (isContainBlank(carNames)) {
            throw new IllegalStateException("자동차 이름에 공백이 있으면 안됩니다.");
        }
        if (!isUniqueCarName(carNames)) {
            throw new IllegalStateException("중복된 자동차를 입력하였습니다.");
        }
    }

    public boolean isCorrectCarLength(String carNames) {
        List<String> cars = ConverterUtil.covertStringToList(carNames);
        for (String car : cars) {
            if (car.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public boolean isContainBlank(String carNames) {
        return carNames.isBlank();
    }

    public boolean isUniqueCarName(String carNames) {
        List<String> cars = ConverterUtil.covertStringToList(carNames);
        HashSet<String> uniqueNames = new HashSet<>();
        for (String car : cars) {
            if (!uniqueNames.add(car)) {
                return false;
            }
        }
        return true;
    }
}
