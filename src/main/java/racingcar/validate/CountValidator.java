package racingcar.validate;

public class CountValidator {
    public static Integer numberValidate(String input) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하셔야 합니다.");
        }
        if (Integer.signum(count) != 1) {
            throw new IllegalArgumentException("양의 정수를 입력하세요.");
        }
        return count;
    }
}
