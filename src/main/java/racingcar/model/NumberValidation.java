package racingcar.model;

public class NumberValidation {
    public int numbervalidateAll(String inputNumber) {
        int tryNumber = validateTryNumber1(inputNumber);
        validateTryNumber2(tryNumber);
        return tryNumber;
    }

    private int validateTryNumber1(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    private void validateTryNumber2(int tryNumber) {
        if (tryNumber < Constants.MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("잘못된 시도 횟수입니다.");
        }
    }
}
