package racingcar.util;

public class TryNumValidator extends Validator{
    private static final String NUMBER_REGEXP = "[/d]+";
    @Override
    public void validate(String tryNum) {
        validateEmptyInput(tryNum);
        validateTryNumIsNum(tryNum);
    }

    // 이동 횟수가 수가 아닌 문자인 경우
    private void validateTryNumIsNum(String tryNum) {
        try{
            Integer.parseInt(tryNum);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NOT_NUMBER_ERROR.getErrorMessage());
        }
    }
}