package racingcar.domain;

public class CarGameRound {

    private final int gameRound;

    private CarGameRound(int gameRound) {
        this.gameRound = gameRound;
    }

    public static CarGameRound createByString(String gameRound) {
        try {
            return new CarGameRound(Integer.parseInt(gameRound));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자이어야 합니다.", e);
        }
    }

    public boolean isRunning(int currentRound) {
        return gameRound > currentRound;
    }
}
