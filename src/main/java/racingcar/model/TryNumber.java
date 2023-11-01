package racingcar.model;

public class TryNumber {
    int tryNumber;
    static final int MIN_TRY_NUMBER = 1;

    public TryNumber(String tryNumberString) {
        int number = TryNumberStringToInt(tryNumberString);
        validateTryNumber(number);
        this.tryNumber = number;
    }

    private int TryNumberStringToInt(String tryNumberString) {
        try {
            return Integer.parseInt(tryNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateTryNumber(int number) {
        if(number < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
