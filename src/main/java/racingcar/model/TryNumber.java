package racingcar.model;

import racingcar.enums.Constants;
import racingcar.enums.Exceptions;
import racingcar.exception.TryNumberSizeException;

public class TryNumber {
    private Integer number;

    public TryNumber(Integer number) {
        validateTryNumberSize(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private void validateTryNumberSize(Integer number) {
        if (isNumberUnder0(number)) {
            throw new TryNumberSizeException(Exceptions.TRY_NUMBER_IS_UNDER_0.getMessage());
        }
    }

    private boolean isNumberUnder0(Integer number) {
        if (number < Constants.ZERO.getNumber()) {
            return true;
        }
        return false;
    }
}
