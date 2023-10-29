package racingcar.Util;

import racingcar.Constants.ExceptionMessage;

public class Validator {



    private String[] validationNameLength(String[] name){
        for (String s : name) {
            checkNameLength(s);
        }
        return name;
    }

    private void checkNameLength(String carName){
        if(carName.isEmpty() || 5 < carName.length()){
            ExceptionMessage.OUT_OF_LENGTH.throwexception();
        }
    }
}
