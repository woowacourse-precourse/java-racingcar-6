package racingcar;

public final class MovingCount {
    private final int count;

    private MovingCount(String input) {
        validateInputIsDigit(input);
        this.count = Integer.parseInt(input);
    }

    public static MovingCount createMovingCount(String input) {
        return new MovingCount(input);
    }

    private void validateInputIsDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("이동 횟수는 숫자만 가능합니다.");
        }
    }

    public boolean isNotEqual(int i) {
        return count != i;
    }
}
