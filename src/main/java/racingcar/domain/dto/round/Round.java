package racingcar.domain.dto.round;

public record Round(int value) {

    private static final int MIN_ROUND = 1;

    public Round {
        validateMinRound(value);
    }

    private static void validateMinRound(final int value) {
        if (value < MIN_ROUND) {
            throw new IllegalArgumentException("최소 라운드 수는 1입니다.");
        }
    }

    public static Round from(final String input) {
    }
}
