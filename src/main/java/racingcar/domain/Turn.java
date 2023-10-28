package racingcar.domain;

public class Turn {
    private final int count;

    public Turn(String count) {
        validateTryToMoveCount(count);
        this.count = Integer.parseInt(count);
    }

    public int getCount() {
        return count;
    }

    private void validateTryToMoveCount(String tryToMoveCount) {
        if (isNotNumberFormat(tryToMoveCount)) {
            throw new IllegalArgumentException("이동 횟수는 숫자값만 입력 가능합니다.");
        }
    }

    private boolean isNotNumberFormat(String text) {
        return !text.matches("\\d+");
    }
}
