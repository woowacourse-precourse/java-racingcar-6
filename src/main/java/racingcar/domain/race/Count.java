package racingcar.domain.race;

public record Count(
        int count
) {
    private static final int MIN_COUNT = 1;

    public Count {
        validate(count);
    }

    private void validate(final int count) {
        validateMin(count);
    }

    private void validateMin(final int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("레이스 횟수는 1 이상이어야 합니다.");
        }
    }
}
