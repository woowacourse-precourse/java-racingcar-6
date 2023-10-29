package racingcar.validation;

import static racingcar.constant.MessageConst.DUPLICATE_MESSAGE;
import static racingcar.constant.MessageConst.LENGTH_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidation {

    public void validateCarNameRange(List<String> carNames) {
        for (String carName : carNames) {
            int carNameLength = carName.length();
            isRangeValid(carNameLength);
        }
    }

    public void isRangeValid(int carNameLength) {
        if (carNameLength < 1 || carNameLength > 5) {
            throw new IllegalArgumentException(LENGTH_MESSAGE);
        }
    }

    public void validateCarNameDuplication(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        if (set.size() < carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }
}
