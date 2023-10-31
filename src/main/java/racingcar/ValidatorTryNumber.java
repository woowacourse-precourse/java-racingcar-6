package racingcar;

public class ValidatorTryNumber {
    public static int tryNumber = 0;

    public ValidatorTryNumber() {

    }

    public void checkNum(String number) {
        isNaturalNumber(number);
        isEnteredZero(number);

        this.tryNumber = Integer.parseInt(number);
    }

    public static int getTryNumber() {
        return tryNumber;
    }

    private void isEnteredZero(String number) throws IllegalArgumentException {
        int num = Integer.parseInt(number);
        if(num == 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야합니다.");
        }
    }

    private void isNaturalNumber(String number) throws IllegalArgumentException {
        int num = Integer.parseInt(number);
        if(num < 0) {
            throw new IllegalArgumentException("시도 횟수는 양수를 입력하세요.");
        }
    }
}
