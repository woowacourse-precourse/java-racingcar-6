package racingcar.common.type;

import racingcar.common.validator.TrialCountValidator;

public final class TrialCount {
    private final int count;

    private TrialCount(int count) {
        TrialCountValidator.validate(count);
        this.count = count;
    }

    public static TrialCount of(String countString) {
        int count;
        try {
            count = Integer.parseInt(countString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수 형태만 가능합니다.");
        }

        return new TrialCount(count);
    }

    public int getCount() {
        return count;
    }
}
