package racingcar.util;

import racingcar.view.ErrorMessage;

public class GameRoundValidator {
    public static void validInputInteger(String input){
        for(int i=0; i<input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException(ErrorMessage.REQUIRE_INTEGER_TYPE.message());
        }
    }

    public static void validNotUnderZero(int num){
        if(num<=0) throw new IllegalArgumentException(ErrorMessage.REQUIRE_OVER_ONE.message());
    }
}
