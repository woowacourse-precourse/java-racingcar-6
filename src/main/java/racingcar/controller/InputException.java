package racingcar.controller;

import java.util.regex.Pattern;

import static racingcar.utility.Constants.IMPROPER_COMMA_POSITION;

public class InputException {

    public InputException(){}

    public void carsNameException(){}

    private boolean isCommaAtImproperPosition(String carsName){
        return(Pattern.matches(IMPROPER_COMMA_POSITION,carsName));
    }
}
