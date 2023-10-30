package validator;

import message.ErrorMessage;

import java.util.List;

public class Validator {
    String regExp = "^[1-9]*$";
    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final int MIN_LENGTH_OF_NAME = 1;

    public void checkLengthName(List<String> names) {
        for(String name : names) {//공백은 길이에 포함
            System.out.println(name.length());

            if(name.isEmpty()) {//""는 빈 문자열
                throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NAME_UNDER);
            }

            if(name.length() > MAX_LENGTH_OF_NAME) {
                throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NAME_OVER);
            }
        }
    }

    public int checkTryNumber(String tryNumber) {
        if(!(tryNumber.matches(regExp))) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_TRY_NUMBER);
        }
        return Integer.parseInt(tryNumber);
    }
}
