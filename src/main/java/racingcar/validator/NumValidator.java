package racingcar.validator;

import static racingcar.validator.Constants.*;

public class NumValidator {
    public static String NUM = null;

    public NumValidator(String num) {
        try {
            NUM = num;
            int numInt = Integer.parseInt(NUM);
            validateIsInt(numInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }
    //숫자인지 확인
    public void validateIsInt(int numInt){
        if(numInt<1|| numInt>9){
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }
}
