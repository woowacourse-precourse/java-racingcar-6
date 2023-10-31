package racingcar.controller;

import java.util.regex.Pattern;

import static racingcar.utility.Constants.IMPROPER_COMMA_POSITION;

public class InputException {

    public InputException(){}

    public void carsNameException(String carsName){
        if(isCarsNameEmpty(carsName)){ //문자열에 비었을 때 (엔터 입력시)
            throw new IllegalArgumentException();
        }

        if(isCommaAtImproperPosition(carsName)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isCommaAtImproperPosition(String carsName){
        return(Pattern.matches(IMPROPER_COMMA_POSITION,carsName));
    }

    private boolean isCarsNameEmpty(String carsName){
        if(carsName.length() == 0){
            return true;
        }
        return false;
    }
}
