package racingcar.exception;

import java.util.List;

public class TryCountInputErrorException implements InputErrorException{
    private final static String TRY_INPUT_IS_EMPTY_MESSAGE = "값을 입력해주세요. 게임을 종료합니다.";
    @Override
    public void checkUserInputValidate(String checkString) {
        if (isEmptyString(checkString)){
            throw new IllegalArgumentException(TRY_INPUT_IS_EMPTY_MESSAGE);
        }
    }

    private static boolean isEmptyString(String checkString){
        return checkString.isEmpty();
    }
}
