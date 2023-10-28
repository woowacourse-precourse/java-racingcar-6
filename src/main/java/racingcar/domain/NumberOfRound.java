package racingcar.domain;

public record NumberOfRound(
        int value
) {
    public NumberOfRound {
        validate(value);
    }

    public boolean hasRoundsLeft() {
        return value > 0;
    }

    public NumberOfRound consumeRound() {
        return new NumberOfRound(value - 1);
    }

    private void validate(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력 가능합니다.");
        }
    }
}
