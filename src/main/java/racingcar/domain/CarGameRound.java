package racingcar.domain;

import java.util.Objects;

public class CarGameRound {
    private static final String GAMR_ROUND_MUST_DIGIT = "시도할 횟수는 숫자이어야 합니다.";

    private final int gameRound;

    private CarGameRound(int gameRound) {
        this.gameRound = gameRound;
    }

    public static CarGameRound createByString(String gameRound) {
        try {
            return new CarGameRound(Integer.parseInt(gameRound));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GAMR_ROUND_MUST_DIGIT, e);
        }
    }

    public boolean isRunning(int currentRound) {
        return gameRound > currentRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarGameRound that = (CarGameRound) o;
        return gameRound == that.gameRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameRound);
    }
}
