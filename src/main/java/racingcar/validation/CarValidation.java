package racingcar.validation;

import static racingcar.constant.MessageConst.LENGTH_MESSAGE;

import java.util.List;

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

}
