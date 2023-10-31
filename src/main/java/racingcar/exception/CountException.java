package racingcar.exception;

public class CountException {

    // 횟수
    // 숫자가 아닌 경우
    public static void isNotNumber(int number) {

        if (!String.valueOf(number).matches("\\d+")) {
            throw new IllegalArgumentException(number + " -> 숫자만 입력해주세요.");
        }
    }

    // 0인 경우
    public static void isNotPositiveNumber(int count) {
        if (count == 0) {
            throw new IllegalArgumentException(count + " -> 양의 정수만 입력해주세요. ");
        }
    }

}
