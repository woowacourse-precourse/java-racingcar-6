package racingcar.service;

public class RepeatNumberCheck {

    public static void isNothing(String repeatNumber) {
        if (repeatNumber.length() == 0) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public static void isNumber(String repeatNumber) {
        for (int i = 0; i < repeatNumber.length(); i++) {
            if (!Character.isDigit(repeatNumber.charAt(i))) {
                throw new IllegalArgumentException("숫자를 입력해야 합니다.");
            }
        }
    }

    public static void isOne(String repeatNumber) {
        if (repeatNumber.equals("0")) {
            throw new IllegalArgumentException("시도할 횟수는 0보다 커야 합니다.");
        }
    }

    public void checkAll(String repeatNumber) {
        isNothing(repeatNumber);
        isNumber(repeatNumber);
        isOne(repeatNumber);
    }
}
