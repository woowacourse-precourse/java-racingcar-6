package racingcar.validator;

import static racingcar.validator.Constants.*;

public class NumValidator {
    public static String NUM = null;

    public NumValidator(String num) {
        NUM = num;
        validateIsInt();
    }
    //숫자인지 확인
    public void validateIsInt(){
        if(Integer.parseInt(NUM)<'0'|| Integer.parseInt(NUM)>'9'){
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }
}
