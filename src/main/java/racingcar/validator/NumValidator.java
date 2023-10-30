package racingcar.validator;

import static racingcar.validator.Constants.*;

public class NumValidator {
    public static String NUM = null;

    public NumValidator(String num) {
        NUM = num;
        validate();
    }
    public void validate(){
        isInt();
    }
    //숫자인지 확인
    public void isInt(){
        if(Integer.parseInt(NUM)<'0'|| Integer.parseInt(NUM)>'9'){
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }
}
