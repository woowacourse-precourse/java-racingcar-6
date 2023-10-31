package racingcar.util;

public class validation_attempts {

    public static Integer validation_attempts(String attempts) {
        int n = toInt(attempts);
        if (n < 1) {
            throw new IllegalArgumentException("시도 횟수는 1번 이상이여야 합니다.");
        }
        return n;
    }

    public static int toInt(String attempts) {
        try {
            int n = Integer.parseInt(attempts);
            return n;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

}
