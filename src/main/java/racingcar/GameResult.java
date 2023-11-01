package racingcar;

public class GameResult {

    private final GameRankings gameRanking;
    private final RacingCarWinners winners;

    public GameResult(final GameRankings gameRanking) {
        this.gameRanking = gameRanking;
        winners = gameRanking.findWinners();
    }

    public GameRankings getEachRoundResult() {
        return gameRanking;
    }

    public RacingCarWinners getWinners() {
        return winners;
    }
}
