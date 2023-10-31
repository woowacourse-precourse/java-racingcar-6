package racingcar.domain;

public class CarGameRound {

    private final int finishGameRound;
    private int currentGameRound;

    public CarGameRound(int finishGameRound) {
        this.finishGameRound = finishGameRound;
    }

    private static final String GAMR_ROUND_MUST_DIGIT = "시도할 횟수는 숫자이어야 합니다.";

    public static CarGameRound createByString(String gameRound) {
        try {
            return new CarGameRound(Integer.parseInt(gameRound));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GAMR_ROUND_MUST_DIGIT, e);
        }
    }

    public boolean isRunning() {
        return finishGameRound > currentGameRound;
    }

    public void nextRound() {
        currentGameRound += 1;
    }
}
