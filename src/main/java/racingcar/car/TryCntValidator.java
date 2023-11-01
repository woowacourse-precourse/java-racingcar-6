package racingcar.car;

import racingcar.Constants;

public class TryCntValidator {

    public final String TRY_COUNT;

    public TryCntValidator(String tryCnt) {
        this.TRY_COUNT = tryCnt;
    }

    public void validate(){
        isInteger();
    }

    public void isInteger() {
        if (!Constants.TRY_COUNT_PATTERN.matcher(TRY_COUNT).matches()) {
            throw new IllegalArgumentException(Constants.ERROR + Constants.INPUT_ONLY_INTEGER_ERROR_MESSAGE);
        }
    }
}
