package racingcar.util;

import static racingcar.exception.ExceptionMessage.ILLEGAL_TRY_COUNT;

public class TryCountValidator {
    public final String TRY_COUNT_STRING;
    public TryCountValidator(String tryCountString){
        this.TRY_COUNT_STRING = tryCountString;
        validate();
    }
    public void validate(){
        if(Integer.parseInt(TRY_COUNT_STRING) < 0){
            throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
        }
    }
}