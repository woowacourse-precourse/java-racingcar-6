package validator;

import util.NameConstant;

public class CarNamInputValidator {

    public void validate() {

    }

    public void isNameBelowFiveLetters(String input) {
        if(input.length()>NameConstant.MAX_LENGTH){
            throw new IllegalArgumentException("다섯 글자이하의 입력값이 아닙니다.");
        }
    }
}
