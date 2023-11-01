package racingcar.util;

import racingcar.view.ErrorMessage;

public class CommonValidator {

    public static void validInputBlank(String input){
        if(input.isBlank()) throw new IllegalArgumentException(ErrorMessage.BLANK_STRING.message());
    }
}
