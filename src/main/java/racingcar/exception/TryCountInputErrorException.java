package racingcar.exception;

import java.util.List;

public class TryCountInputErrorException implements InputErrorException{
    private final static String TRY_INPUT_IS_EMPTY_MESSAGE = "값을 입력해주세요. 게임을 종료합니다.";
    private final static String TRY_INPUT_IS_NOT_NUMBER = "숫자만 입력이 가능합니다. 게임을 종료합니다.";
    private final static String NUMBER_REGULAR_EXPRESSION = "\\d+";
    @Override
    public void checkUserInputValidate(String checkString) {
        if (isEmptyString(checkString)){
            throw new IllegalArgumentException(TRY_INPUT_IS_EMPTY_MESSAGE);
        }else if (isNumeric(checkString)){
            throw new IllegalArgumentException(TRY_INPUT_IS_NOT_NUMBER);
        }
    }

    private static boolean isEmptyString(String checkString){
        return checkString.isEmpty();
    }

    private static boolean isNumeric(String checkString){
        return !checkString.matches(NUMBER_REGULAR_EXPRESSION);
    }
}
