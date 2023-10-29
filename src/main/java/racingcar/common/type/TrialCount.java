package racingcar.common.type;

public record TrialCount(int count) {
    public TrialCount {
        validate(count);
    }

    private void validate(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
