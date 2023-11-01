package racingcar.exception;

import racingcar.exception.constant.ErrorMessageConstant;

public class TryCountInputErrorException implements InputErrorException{
    private final static String NUMBER_REGULAR_EXPRESSION = "\\d+";

    @Override
    public void checkUserInputValidate(String checkString) {
        if (isEmptyString(checkString)){
            throw new IllegalArgumentException(ErrorMessageConstant.INPUT_EMPTY_ERROR_MESSAGE.getMessage());
        }else if (isNumeric(checkString)){
            throw new IllegalArgumentException(ErrorMessageConstant.TRY_INPUT_IS_NOT_NUMBER_MESSAGE.getMessage());
        }
    }

    private static boolean isEmptyString(String checkString){
        return checkString.isEmpty();
    }

    private static boolean isNumeric(String checkString){
        return !checkString.matches(NUMBER_REGULAR_EXPRESSION);
    }
}
