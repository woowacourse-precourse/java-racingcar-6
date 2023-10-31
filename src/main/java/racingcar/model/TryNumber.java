package racingcar.model;

public class TryNumber {
    public String tryNumber;

    public String getTryNumber() {
        return tryNumber;
    }

    public void setTryNumber(String tryNumber) throws IllegalArgumentException {
        tryNumberValidation(tryNumber);
        this.tryNumber = tryNumber;
    }

    public void tryNumberValidation(String tryNumber) {
        isDigitString(tryNumber);
        isNull(tryNumber);
    }

    public void isDigitString(String tryNumber) throws IllegalArgumentException {
        for (int i = 0; i < tryNumber.length(); i++) {
            isDigitChar(tryNumber.charAt(i));
        }
    }

    public void isDigitChar(char tryNum) throws IllegalArgumentException {
        if (!Character.isDigit(tryNum)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다(숫자가 아닌 값)");
        }
    }

    public static void isNull(String tryNumber) throws IllegalArgumentException {
        if (tryNumber.isEmpty()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다(Null)");
        }
    }

}
