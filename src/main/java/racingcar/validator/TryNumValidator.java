package racingcar.validator;

import racingcar.constant.ErrorMessage;
import racingcar.constant.ValidatorConstant;

public class TryNumValidator extends Validator{
    @Override
    public void validate(String tryNum) {
        validateEmptyInput(tryNum);
        validateTryNumIsNum(tryNum);
        validateTryNumIsZero(tryNum);
    }

    /***
     * 이동 횟수가 수가 아닌 문자가 들어온 경우
     */
    private void validateTryNumIsNum(String tryNum) {
        try{
            Integer.parseInt(tryNum);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NOT_NUMBER_ERROR.getErrorMessage());
        }
    }

    /***
     * 이동 횟수가 0이 입력된 경우
     */
    private void validateTryNumIsZero(String tryNum) {
        if(tryNum.equals(ValidatorConstant.INVALID_TRY_NUM.getValue())) throw new IllegalArgumentException(ErrorMessage.TRY_NUM_IS_ZERO_ERROR.getErrorMessage());
    }
}