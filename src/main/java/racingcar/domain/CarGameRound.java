package racingcar.domain;

public record CarGameRound(int gameRound) {
    
    private static final String GAMR_ROUND_MUST_DIGIT = "시도할 횟수는 숫자이어야 합니다.";

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
}
