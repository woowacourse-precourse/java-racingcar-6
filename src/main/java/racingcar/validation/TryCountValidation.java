package racingcar.validation;

import static racingcar.constant.Constant.ONE;
import static racingcar.constant.Constant.ZERO;
import static racingcar.constant.ValidateMessage.TRY_COUNT_MUST_BE_INTEGER;
import static racingcar.constant.ValidateMessage.TRY_COUNT_MUST_BE_MORE_THAN_ONE;
import static racingcar.constant.ValidateMessage.TRY_COUNT_MUST_NOT_BE_NULL_OR_EMPTY;

public class TryCountValidation {

    public void isNullOrEmpty(String tryCount) {
        if (tryCount == null || tryCount.length() == ZERO.number) {
            TRY_COUNT_MUST_NOT_BE_NULL_OR_EMPTY.throwException();
        }
    }

    public int isInteger(String tryCount) {
        if (!isNumeric(tryCount)) {
            TRY_COUNT_MUST_BE_INTEGER.throwException();
        }
        return Integer.parseInt(tryCount);
    }

    private boolean isNumeric(String purchasePrice) {
        try {
            Integer.parseInt(purchasePrice);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public int isMoreThanOne(int tryCount) {
        if (tryCount < ONE.number) {
            TRY_COUNT_MUST_BE_MORE_THAN_ONE.throwException();
        }
        return tryCount;
    }
}
