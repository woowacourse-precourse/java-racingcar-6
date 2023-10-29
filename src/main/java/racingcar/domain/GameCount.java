package racingcar.domain;

import java.util.Objects;

public class GameCount {
    private static final String NOT_A_NUMBER_MESSAGE = "게임 횟수는 숫자여야 합니다.";
    private static final String LESS_THAN_ONE_MESSAGE = "게임 횟수는 0 이상이어야 합니다.";

    private int count;

    public GameCount(final String input) {
        this.count = validateAndParse(input);
    }

    public void increase(){
        this.count++;
    }

    private int validateAndParse(final String input) {
        try {
            int count = Integer.parseInt(input);
            if (count < 0) {
                throw new IllegalArgumentException(LESS_THAN_ONE_MESSAGE);
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GameCount gameCount = (GameCount) obj;
        return count == gameCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
