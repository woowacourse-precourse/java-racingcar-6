package racingcar.domain;

public record NumberOfRound(
        int value
) {
    public NumberOfRound {
        validate(value);
    }

    public NumberOfRound consumeRound() {
        return new NumberOfRound(value - 1);
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("0 이상의 숫자만 입력 가능합니다.");
        }
    }
}
