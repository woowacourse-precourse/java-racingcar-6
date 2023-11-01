package racingcar.domain;

public class Racing {
    private static int count;

    public Racing(String count) {
        validateMoveCount(count);
        this.count = Integer.parseInt(count);
    }

    public static int getCount() {
        return count;
    }

    private void validateMoveCount(String Count) {
        if (!isNumberFormat(Count)) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야만 합니다");
        }
    }

    private boolean isNumberFormat(String text) {
        return text.matches("\\d+");
    }
}
