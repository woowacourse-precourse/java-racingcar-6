package racingcar.util;

import static racingcar.model.Racer.SEPERATOR;

public class ValidateSize {
    public ValidateSize(){}

    public static void check(String value){
        if(value == null || value.split(SEPERATOR).length == 0){
            throw new IllegalArgumentException("참가자가 없습니다");
        }
    }
}
