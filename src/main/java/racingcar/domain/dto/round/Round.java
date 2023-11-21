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
        validateRound(input);
        return new Round(Integer.parseInt(input));
    }

    private static void validateRound(final String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("라운드는 반드시 숫자를 입력해야 합니다.");
            }
        }
    }

    public static Round first() {
        return new Round(MIN_ROUND);
    }

    public boolean isSameAs(final Round other) {
        return value == other.value;
    }

    public Round increased() {
        return new Round(value - 1);
    }
}
