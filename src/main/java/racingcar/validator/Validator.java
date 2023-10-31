package racingcar.validator;

import racingcar.message.ErrorMessage;

import java.util.List;

public class Validator {
    private static final int MAX_LENGTH_OF_NAME = 5;
    String regExpTryNumber = "^[1-9]*$";
    String regExpStatus = "^[1-2]*$";

    public void checkLengthName(List<String> names) {
        for(String name : names) {//공백은 길이에 포함
            if(name == null) {
                throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NAME_NULL);
            }

            if(name.isEmpty()) {//""는 빈 문자열
                throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NAME_UNDER);
            }

            if(name.length() > MAX_LENGTH_OF_NAME) {
                throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NAME_OVER);
            }
        }
    }

    public int checkRegExpTryNumber(String tryNumber) {
        if(!(tryNumber.matches(regExpTryNumber))) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_TRY_NUMBER);
        }
        return Integer.parseInt(tryNumber);
    }

    public String checkRegExpProcess(String progress) {
        if(!(progress.matches(regExpStatus))) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_STATUS);
        }
        return progress;
    }
}
