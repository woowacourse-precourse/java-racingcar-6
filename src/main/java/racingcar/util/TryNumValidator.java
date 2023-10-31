package racingcar.util;

public class TryNumValidator extends Validator{
    private static final String NUMBER_REGEXP = "[/d]+";
    @Override
    public void validate(String tryNum) {
        validateEmptyInput(tryNum);
        validateTryNumIsNum(tryNum);
        validateTryNumIsZero(tryNum);
    }

    // 이동 횟수가 수가 아닌 문자인 경우
    private void validateTryNumIsNum(String tryNum) {
        try{
            Integer.parseInt(tryNum);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NOT_NUMBER_ERROR.getErrorMessage());
        }
    }

    // 이동 횟수가 0이 입력되었을 경우
    private void validateTryNumIsZero(String tryNum) {
        if(tryNum.equals("0")) throw new IllegalArgumentException(ErrorMessage.TRY_NUM_IS_ZERO_ERROR.getErrorMessage());
    }
}