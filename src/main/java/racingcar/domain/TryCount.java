package racingcar.domain;

public record TryCount(int value) {

    public TryCount {
        checkCount(value);
    }

    private void checkCount(int count) {
        checkPositive(count);
        checkMax(count);
    }

    private void checkPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("자연수만 입력 가능합니다.");
        }
    }

    private void checkMax(int count) {
        if (count >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }
}
