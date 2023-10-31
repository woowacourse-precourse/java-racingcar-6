package racingcar;

import java.util.Arrays;

public class InputValidator {

    private static final String ILLEGAL_NAME_SIZE_EXCEPTION_MESSAGE = "자동차 이름은 5자리 이하로 만들어야 합니다";
    private static final String VOID_NAME_EXCEPTION_MESSAGE = "자동차 이름은 공백으로 설정할 수 없습니다.";
    private static final String DUPLICATE_NAME_EXCEPTION_MESSAGE = "자동차 이름이 중복됩니다.";
    private static final String ZERO_ATTEMPT_NUMBER_EXCEPTION_MESSAGE = "시도 횟수는 1이상이어야 합니다.";
    private static final String ILLEGAL_ATTEMPT_NUMBER_EXCEPTION_MESSAGE = "시도 횟수는 숫자여야 합니다.";

    char temp;

    public void checkString(String[] input) {
        checkStringLength(input);
        checkDuplicateString(input);

    }

    public void checkNumber(String number){
        isNumberZero(number);
        isNumberDigit(number);
    }

    public void checkStringLength(String[] input){
        for (String str : input) {
            if (str.length() > 5) {
                throw new IllegalArgumentException(ILLEGAL_NAME_SIZE_EXCEPTION_MESSAGE);
            }
            if (str.isEmpty()){
                throw new IllegalArgumentException(VOID_NAME_EXCEPTION_MESSAGE);
            }
        }
    }

    public void checkDuplicateString(String[] input){
        if(Arrays.stream(input).distinct().count() != input.length){
            throw new IllegalArgumentException(DUPLICATE_NAME_EXCEPTION_MESSAGE);
        }
    }

    public void isNumberZero(String number){
        if(number.equals("0")){
            throw new IllegalArgumentException(ZERO_ATTEMPT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public void isNumberDigit(String number){
        for(int i = 0; i<number.length(); i++){
            temp = number.charAt(i);
            if (!Character.isDigit(temp)){
                throw new IllegalArgumentException(ILLEGAL_ATTEMPT_NUMBER_EXCEPTION_MESSAGE);
            }
        }
    }
}
