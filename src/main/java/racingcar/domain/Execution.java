package racingcar.domain;

public class Execution {
    public static int count;

    public Execution(String input) {
        validateFormat(input);
        validatePositive(input);

        count = Integer.parseInt(input);
    }

    private void validateFormat(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("올바른 정수를 입력하세요.");
        }
    }

    private void validatePositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }
}
