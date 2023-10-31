package racingcar.domain;

public class RoundCount {
    private final int roundCount;

    public RoundCount(String roundCount) {
        this.roundCount = validateRoundCount(roundCount);
    }

    public int getRoundCount() {
        return roundCount;
    }

    private int validateRoundCount(String roundCount) {
        try {
            int count = Integer.parseInt(roundCount);
            if (count <= 0) {
                throw new IllegalArgumentException("라운드 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드 횟수가 숫자가 아닙니다.");
        }
    }
}
