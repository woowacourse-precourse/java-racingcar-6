package racingcar.model;

public class TryNumber {

    private String clearTryNumber;

    public void setClearTryNumber(String tryNumber) {
        isNumeric(tryNumber);
        isDigits(tryNumber);
        this.clearTryNumber = tryNumber;
    }

    public int getTryNumber() {
        return Integer.parseInt(this.clearTryNumber);
    }

    public void isNumeric(String tryNumber) throws IllegalArgumentException {
        for (int i = 0; i < tryNumber.length(); i++) {
            if (!Character.isDigit(tryNumber.charAt(i))) {
                throw new IllegalArgumentException("1이상의 정수를 입력해주세요.");
            }
        }
    }

    public void isDigits(String tryNumber) throws IllegalArgumentException {
        if (Integer.parseInt(tryNumber) <= 0) {
            throw new IllegalArgumentException("1이상의 정수를 입력해주세요.");
        }

    }

}
