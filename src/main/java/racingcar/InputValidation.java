package racingcar;

import racingcar.exception.InvalidTryInputFormatException;

public class InputValidation {

    public Integer tryInputNumberValidate(String tryInput) {
        if(!tryInput.matches("(\\d)+")){
            throw new InvalidTryInputFormatException();
        }
        return Integer.valueOf(tryInput);
    }
}
