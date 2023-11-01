package racingcar.controller;

import static racingcar.util.ConstantUtil.LONG_NAME_INPUT;

public class ValidationController {

    public void validateNameNumber(String input) {
        if(input.length()>=5){
            throw new IllegalArgumentException(LONG_NAME_INPUT);
        }

    }
    public boolean validateNumber(int number) {
        if(number >= 4) {
            return true;
        }
        return false;
    }
}
