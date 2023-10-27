package racingcar.domain;

public class GameRound {

    private static final Integer MIN_ROUND_COUNT = 1;

    private final int totalRound;
    private int currentRound;

    public GameRound(int totalRound, int currentRound) {
        validateTotalRound(totalRound);
        this.totalRound = totalRound;
        this.currentRound = currentRound;
    }

    public Boolean isLeftRound() {
        return currentRound < totalRound ? true : false;
    }

    private void validateTotalRound(int totalRound) {
        if (totalRound < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("[ERROR] 게임 실행 회수 입력값은 1 이상이어야 합니다.");
        }
    }


}
