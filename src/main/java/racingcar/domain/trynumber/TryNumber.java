package racingcar.domain.trynumber;

import racingcar.constant.ErrorMessage;

public class TryNumber {
    private String tryNumber;

    public String getTryNumber(){
        return tryNumber;
    }

    // 시도 회수 값 설정하기
    public void setTryNumber(String tryNumber) throws IllegalArgumentException {
        tryNumberValidation(tryNumber);
        this.tryNumber = tryNumber;
    }

    // 시도 회수 값 검증하기
    public void tryNumberValidation(String tryNumber) {
        isDigitString(tryNumber);
        isNull(tryNumber);
    }


    public void isDigitString(String tryNumber) throws IllegalArgumentException {
        for (int i = 0; i < tryNumber.length(); i++){
            isDigitChar(tryNumber.charAt(i));
        }
    }

    // 시도 회수 값이 숫자인지 확인하기
    public void isDigitChar(char tryNum) throws IllegalArgumentException {
        if (!Character.isDigit(tryNum)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NOT_DIGIT_ERROR.print());
        }
    }

    // 시도 회수 값 널인지 확인하기
    public static void isNull(String tryNumber) throws IllegalArgumentException {
        if (tryNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NULL_ERROR.print());
        }
    }
}
