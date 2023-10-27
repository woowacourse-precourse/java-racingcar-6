package racingcar.domain;

public enum CarRaceCountRule {

    MIN_COUNT(1),
    MAX_COUNT(10);

    private final int count;

    CarRaceCountRule(final int count) {
        this.count = count;
    }

    public static void validateCount(final String inputCount) {
        validateNumber(inputCount);
        validateRange(Integer.parseInt(inputCount));
    }

    private static void validateNumber(final String inputCount) {
        try {
            Integer.parseInt(inputCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력해야 합니다.");
        }
    }

    private static void validateRange(final int inputCount) {
        if (MIN_COUNT.count > inputCount || MAX_COUNT.count < inputCount) {
            throw new IllegalArgumentException("시도 횟수는 1 이상 10 이하의 숫자를 입력해야 합니다.");
        }
    }
}
